package com.vsfe.largescale.repository;

import com.vsfe.largescale.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    // @Query("""
    // SELECT u
    // FROM User u
    // ORDER BY u.createDate DESC
    // LIMIT :count
    // """)

    // 위의 쿼리는 잘못된 쿼리 (원하는 상황대로 동작하지 않을 수 있음)
    // - 데이터가 많을 때, 유저가 가입한 시간이 동일하면 어떻게 할래?
    // - 트래픽이 많게 되면, 시간은 겹칠 확률이 무조건 증가해서 조건을 하나 더 넣어야함

    // index: user_idx01 (create_date, user_id) -> 이런거 센스로 주석 달아주자
    // 해당 메서드 실행 시, socketTimeout 으로 인한 오류가 발생할 것
    // theme02.sql 가서 설명 보고 오기

    // index: user_idx05 (create_date DESC, user_id ASC)
    // 몽고디비 식 표기는 -1
    // index: user_idx05 (create_date_-1, user_id)
    @Query("""
    SELECT u
    FROM User u
    ORDER BY u.createDate DESC, u.id ASC
    LIMIT :count
    """)
    List<User> findRecentCreatedUsers(@Param("count") int count);
}
