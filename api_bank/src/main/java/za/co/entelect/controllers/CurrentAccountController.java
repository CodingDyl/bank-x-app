package za.co.entelect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.entelect.dtos.currentAccount.CreateCurrentAccountDTO;
import za.co.entelect.dtos.currentAccount.CurrentAccountDTO;
import za.co.entelect.dtos.currentAccount.UpdateCurrentAccountDTO;
import za.co.entelect.services.CurrentAccountService;

@RestController
@RequestMapping("/current-accounts")
public class CurrentAccountController {

    @Autowired
    private CurrentAccountService currentAccountService;

    @Autowired
    public CurrentAccountController(CurrentAccountService currentAccountService) {
        this.currentAccountService = currentAccountService;
    }

    @PostMapping
    public ResponseEntity<CurrentAccountDTO> createCurrentAccount(@RequestBody CreateCurrentAccountDTO createCurrentAccountDTO) {
        CurrentAccountDTO currentAccountDTO = currentAccountService.createCurrentAccount(createCurrentAccountDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(currentAccountDTO);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<CurrentAccountDTO> getAccountByNumber(@PathVariable String accountNumber) {
        CurrentAccountDTO currentAccountDTO = currentAccountService.getAccountByNumber(accountNumber);
        return ResponseEntity.ok(currentAccountDTO);
    }

    @GetMapping("/current-account")
    public ResponseEntity<Iterable<CurrentAccountDTO>> getAllCurrentAccounts() {
        Iterable<CurrentAccountDTO> currentAccountDTOS = currentAccountService.getAllCurrentAccounts();
        return ResponseEntity.ok(currentAccountDTOS);
    }

    @PatchMapping("/{accountNumber}")
    public ResponseEntity<Void> updateCurrentAccount(@PathVariable String accountNumber, @RequestBody UpdateCurrentAccountDTO updateCurrentAccountDTO) {
        currentAccountService.updateCurrentAccountBalance(accountNumber, updateCurrentAccountDTO);
        return ResponseEntity.noContent().build();
    }

}
