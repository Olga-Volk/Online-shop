package serivce;

import entity.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BalanceRepository;

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
