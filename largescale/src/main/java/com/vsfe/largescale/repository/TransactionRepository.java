package com.vsfe.largescale.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TransactionRepository {
    private final TransactionJpaRepository transactionJpaRepository;
}
