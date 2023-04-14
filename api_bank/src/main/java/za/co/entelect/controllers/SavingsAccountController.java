package za.co.entelect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.entelect.SavingsAccountRepository;
import za.co.entelect.dtos.savingsAccount.CreateSavingsAccountDTO;
import za.co.entelect.dtos.savingsAccount.SavingsAccountDTO;
import za.co.entelect.dtos.savingsAccount.UpdateSavingsAccount;
import za.co.entelect.services.SavingsAccountService;

import java.util.List;

@RestController
@RequestMapping("/savings")
public class SavingsAccountController {

    @Autowired
    private SavingsAccountService savingsAccountService;

    @Autowired
    public SavingsAccountController(SavingsAccountService savingsAccountService) {
        this.savingsAccountService = savingsAccountService;
    }

    @PostMapping
    public ResponseEntity<SavingsAccountDTO> createSavingsAccount(@RequestBody CreateSavingsAccountDTO createSavingsAccountDTO) {
        SavingsAccountDTO savingsAccountDTO = savingsAccountService.createSavingsAccount(createSavingsAccountDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savingsAccountDTO);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<SavingsAccountDTO> getAccountByNumber(@PathVariable String accountNumber) {
        SavingsAccountDTO savingsAccountDTO = savingsAccountService.getAccountByNumber(accountNumber);
        return ResponseEntity.ok(savingsAccountDTO);
    }

    @GetMapping("/savings")
    public ResponseEntity<Iterable<SavingsAccountDTO>> getAllSavingsAccounts() {
        Iterable<SavingsAccountDTO> savingsAccountDTOS = savingsAccountService.getAllSavingsAccounts();
        return ResponseEntity.ok(savingsAccountDTOS);
    }

    @PatchMapping("/{accountNumber}")
    public ResponseEntity<Void> updateSavingsAccountBalance(@PathVariable String accountNumber, @RequestBody UpdateSavingsAccount updateSavingsAccountDTO) {
        savingsAccountService.updateSavingsAccountBalance(accountNumber, updateSavingsAccountDTO);
        return ResponseEntity.noContent().build();
    }
}
