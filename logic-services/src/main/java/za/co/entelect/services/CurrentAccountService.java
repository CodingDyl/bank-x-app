package za.co.entelect.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.entelect.CurrentAccountRepository;
import za.co.entelect.dtos.currentAccount.CreateCurrentAccountDTO;
import za.co.entelect.dtos.currentAccount.CurrentAccountDTO;
import za.co.entelect.dtos.currentAccount.UpdateCurrentAccountDTO;
import za.co.entelect.entities.CurrentAccount;



import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CurrentAccountService {

    @Autowired
    private CurrentAccountRepository currentAccountRepository;

    public CurrentAccountService(CurrentAccountRepository currentAccountRepository) {
        this.currentAccountRepository = currentAccountRepository;
    }

    public CurrentAccountDTO createCurrentAccount(CreateCurrentAccountDTO createCurrentAccountDTO) {
        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.setAccountNumber(createCurrentAccountDTO.getAccountNumber());
        currentAccount.setBalance(BigDecimal.valueOf(500.00));
        currentAccount = currentAccountRepository.save(currentAccount);

        return CurrentAccountDTO.fromEntity(currentAccount);
    }

    public CurrentAccountDTO getAccountByNumber(String accountNumber) {
        Optional<CurrentAccount> currentAccount = currentAccountRepository.findByAccountNumber(accountNumber);
        return currentAccount.map(CurrentAccountDTO::fromEntity).orElse(null);
    }

    public Iterable<CurrentAccountDTO> getAllCurrentAccounts() {
        Iterable<CurrentAccount> currentAccounts = currentAccountRepository.findAll();
        return StreamSupport.stream(currentAccounts.spliterator(), false)
                .map(CurrentAccountDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public void updateCurrentAccountBalance(String accountNumber, UpdateCurrentAccountDTO updateCurrentAccountDTO) {
        Optional<CurrentAccount> currentAccount = currentAccountRepository.findByAccountNumber(accountNumber);
        currentAccount.ifPresent(savingsAccount -> {
            savingsAccount.setBalance(updateCurrentAccountDTO.getBalance());
            currentAccountRepository.save(savingsAccount);
        });
    }


}
