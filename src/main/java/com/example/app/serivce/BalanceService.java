package com.example.app.serivce;

import com.example.app.entity.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.app.repository.BalanceRepository;

@Service
public class BalanceService {

    @Autowired
    private final BalanceRepository balanceRepository;

    public BalanceService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    public void createBalance(Balance balance) {
        balanceRepository.save(balance);
    }
}
