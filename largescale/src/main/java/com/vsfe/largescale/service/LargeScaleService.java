package com.vsfe.largescale.service;

import com.vsfe.largescale.domain.User;
import com.vsfe.largescale.repository.*;
import jakarta.validation.constraints.Max;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LargeScaleService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    /**
     * 최신 유저의 목록을 가져올 것이다. (count 만큼)
     * "최신"의 조건을 바꿔가면서 쿼리를 날려보자.
     * @param count
     * @return
     */

    // "최신"의 조건을 활용한 시나리오
    // - 최근 가입한 유저한테 어떠한 메시지를 보낼 것이다 (create_date 활용)
    // - 휴면 유저를 어떻게 관리할 지 정할 때 (update_date 활용)

    // 아까 컨트롤러에도 Validation 했지만, Validation 은 많으면 많을 수록 좋다
    // 그러니 서비스에서도 검증해주자 ~
    public List<User> getUserInfo(@Max(100) int count) {
        return userRepository.findRecentCreatedUsers(count);
    }

    public void getTransactions() {

    }

    public void validateAccountNumber() {

    }

    public void aggregateTransactions() {

    }

    public void aggregateTransactionsWithSharding() {

    }
}
