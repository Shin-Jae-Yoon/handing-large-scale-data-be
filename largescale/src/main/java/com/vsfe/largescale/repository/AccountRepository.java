package com.vsfe.largescale.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

// [ JpaRepository, Repository 분리 이유 ]
// 쿼리 중에서 분기 처리 필요하거나
// 내부적으로 가공이 필요할 때가 있어서
// JpaRepository 을 직접적으로 사용하면 제한적일 때가 많아서.

// Q. 그렇다면, save() 같은 간단한 메서드는 어떻게 ?

// 견해1. 컴포지션 해서 그대로 사용
// class repository {
//     private final JpaRepo jpaRepo;
//
//     public void method() {
//         jpaRepo.save();
//     }
// }

// 견해2. save() 처럼 매우 단순한 기능의 경우
// 계층을 뛰어넘을 수도 있어서 그냥 쓰는 경우도 존재

// 컴포넌트 아키텍처는 정답이 없으므로, 팀원과 협의 후 사용

@Repository
@RequiredArgsConstructor
public class AccountRepository {
    private final AccountJpaRepository accountJpaRepository;
}
