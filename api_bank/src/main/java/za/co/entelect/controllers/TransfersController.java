package za.co.entelect.controllers;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.entelect.entities.CurrentAccount;
import za.co.entelect.entities.SavingsAccount;
import za.co.entelect.services.TransfersService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transfers")
public class TransfersController {

    @Autowired
    private TransfersService transfersService;

    @PostMapping("/current")
    public ResponseEntity<Void> transferBetweenAccountsCurrent(
            @RequestBody TransferRequest transferRequest) throws IllegalArgumentException {
        transfersService.transferBetweenAccountsCurrent(
                transferRequest.getSavingsAccount(),
                transferRequest.getCurrentAccount(),
                transferRequest.getAmount());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/savings")
    public ResponseEntity<Void> transferBetweenAccountsSavings(
            @RequestBody TransferRequest transferRequest) throws IllegalArgumentException {
        transfersService.transferBetweenAccountsSavings(
                transferRequest.getSavingsAccount(),
                transferRequest.getCurrentAccount(),
                transferRequest.getAmount());
        return ResponseEntity.ok().build();
    }

    @Data
    public static class TransferRequest {
        private BigDecimal amount;
        private SavingsAccount savingsAccount;
        private CurrentAccount currentAccount;
    }
}
