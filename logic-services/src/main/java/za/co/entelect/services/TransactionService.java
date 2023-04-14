package za.co.entelect.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import za.co.entelect.CurrentAccountRepository;
import za.co.entelect.TransactionRepository;
import za.co.entelect.entities.CurrentAccount;
import za.co.entelect.entities.Transactions;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CurrentAccountRepository currentAccountRepository;

    public TransactionService(TransactionRepository transactionRepository, CurrentAccountRepository currentAccountRepository) {
        this.transactionRepository = transactionRepository;
        this.currentAccountRepository = currentAccountRepository;
    }

    @Transactional
    public void makePurchase(CurrentAccount currentAccount, BigDecimal amount, String description) throws IllegalArgumentException {
        if (currentAccount.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds in the account.");
        }

        BigDecimal charge = amount.multiply(BigDecimal.valueOf(0.0005));

        BigDecimal newAmount = amount.add(charge);

        currentAccount.setBalance(currentAccount.getBalance().subtract(newAmount));

        Transactions transaction = new Transactions();
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setAmount(newAmount);
        transaction.setCharge(charge);
        transaction.setDescription(description);

        transactionRepository.save(transaction);
    }
}