package za.co.entelect.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.entelect.SavingsAccountRepository;
import za.co.entelect.dtos.savingsAccount.CreateSavingsAccountDTO;
import za.co.entelect.dtos.savingsAccount.SavingsAccountDTO;
import za.co.entelect.dtos.savingsAccount.UpdateSavingsAccount;
import za.co.entelect.entities.SavingsAccount;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SavingsAccountService {

    @Autowired
    private SavingsAccountRepository savingsAccountRepository;

    public SavingsAccountService(SavingsAccountRepository savingsAccountRepository) {
        this.savingsAccountRepository = savingsAccountRepository;
    }

    public SavingsAccountDTO createSavingsAccount(CreateSavingsAccountDTO createSavingsAccountDTO) {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountNumber(createSavingsAccountDTO.getAccountNumber());
        savingsAccount.setBalance(BigDecimal.valueOf(500.00));
        savingsAccount = savingsAccountRepository.save(savingsAccount);

        return SavingsAccountDTO.fromEntity(savingsAccount);
    }

    public SavingsAccountDTO getAccountByNumber(String accountNumber) {
        Optional<SavingsAccount> savingsAccount = savingsAccountRepository.findByAccountNumber(accountNumber);
        return savingsAccount.map(SavingsAccountDTO::fromEntity).orElse(null);
    }

    public Iterable<SavingsAccountDTO> getAllSavingsAccounts() {
        Iterable<SavingsAccount> savingsAccounts = savingsAccountRepository.findAll();
        return StreamSupport.stream(savingsAccounts.spliterator(), false)
                .map(SavingsAccountDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public void updateSavingsAccountBalance(String accountNumber, UpdateSavingsAccount updateSavingsAccountDTO) {
        Optional<SavingsAccount> optionalSavingsAccount = savingsAccountRepository.findByAccountNumber(accountNumber);
        optionalSavingsAccount.ifPresent(savingsAccount -> {
            savingsAccount.setBalance(updateSavingsAccountDTO.getBalance());
            savingsAccountRepository.save(savingsAccount);
        });
    }
}
