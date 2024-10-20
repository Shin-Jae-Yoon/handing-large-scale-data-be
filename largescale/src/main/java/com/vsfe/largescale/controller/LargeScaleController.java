package com.vsfe.largescale.controller;

import com.vsfe.largescale.domain.User;
import com.vsfe.largescale.service.LargeScaleService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 예시 중심의 세미나이므로,
 * 실제 서비스와는 달리 사용하는 API만 Controller 형태로 구성했습니다.
 */
@RestController
@RequestMapping("/service")
@RequiredArgsConstructor
public class LargeScaleController {
    private final LargeScaleService largeScaleService;

    /**
     * Step 1. 기본적인 쿼리의 최적화를 수행해 봅시다.
     */

    // 1. 원래는 User 를 model(DTO) 로 바꿔서 넣어줘야 하는데
    // 이정도는 세미나에서 생략하고 진행 ~!

    // 2. 단순히 RequestParam 하지말고 Validation 은 진행해주도록 하자
    // Positive - 유저를 가져오는데, -1명 가져올 수는 없으니까
    // Max - 숫자가 너무 크면 우리 서비스에 문제 생길 수 있으니까

    @GetMapping("/user-info")
    public List<User> getUserInfo(@RequestParam @Positive @Max(100) int count) {
        return largeScaleService.getUserInfo(count);
    }


    /**
     * Step 2. 페이징을 활용한 쿼리 최적화 방식에 대해 고민해 봅시다.
     */
    public void getTransactions() {

    }

    /**
     * Step 3. Full Scan 을 수행해야 하는 로직은 어떻게 수행해야 할까요?
     */
    public void validateAccountNumber() {

    }

    /**
     * Step 4. 통계성 집계를 병렬로 수행해 봅시다.
     */
    public void aggregateTransactions() {

    }

    /**
     * Step 5. 데이터를 샤딩한다면 어떻게 될까요?
     */
    public void aggregateTransactionsWithSharding() {

    }
}
