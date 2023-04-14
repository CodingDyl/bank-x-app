package za.co.entelect.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.entelect.TransferRepository;
import za.co.entelect.entities.CurrentAccount;
import za.co.entelect.entities.SavingsAccount;
import za.co.entelect.entities.Transfers;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransfersService {

    @Autowired
    private TransferRepository transferRepository;

    @Transactional
    public void transferBetweenAccountsCurrent(SavingsAccount savingsAccount, CurrentAccount currentAccount, BigDecimal transferAmount) throws IllegalArgumentException {
        if (currentAccount.getBalance().compareTo(transferAmount) < 0) {
            throw new IllegalArgumentException("Insufficient funds in the source account.");
        }

        currentAccount.setBalance(currentAccount.getBalance().subtract(transferAmount));
        savingsAccount.setBalance(savingsAccount.getBalance().add(transferAmount));

        Transfers transfer = Transfers.builder()
                .transferDate(LocalDateTime.now())
                .amount(transferAmount)
                .currentAccount(currentAccount)
                .savingsAccount(savingsAccount)
                .build();

        transferRepository.save(transfer);
    }

    @Transactional
    public void transferBetweenAccountsSavings(SavingsAccount savingsAccount, CurrentAccount currentAccount, BigDecimal transferAmount) throws IllegalArgumentException {
        if (savingsAccount.getBalance().compareTo(transferAmount) < 0) {
            throw new IllegalArgumentException("Insufficient funds in the source account.");
        }

        savingsAccount.setBalance(savingsAccount.getBalance().subtract(transferAmount));
        savingsAccount.setBalance(savingsAccount.getBalance().add(transferAmount));

        Transfers transfer = Transfers.builder()
                .transferDate(LocalDateTime.now())
                .amount(transferAmount)
                .savingsAccount(savingsAccount)
                .currentAccount(currentAccount)
                .build();

        transferRepository.save(transfer);
    }
}
