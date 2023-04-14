package za.co.entelect.controllers;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.entelect.entities.CurrentAccount;
import za.co.entelect.services.TransactionService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/current")
    public ResponseEntity<Void> makePurchase(
            @RequestBody TransactionRequest transactionRequest) throws IllegalArgumentException {
        CurrentAccount currentAccount = transactionRequest.getCurrentAccount();
        BigDecimal amount = transactionRequest.getAmount();
        String description = transactionRequest.getDescription();

        transactionService.makePurchase(currentAccount, amount, description);

        return ResponseEntity.ok().build();
    }

    @Data
    public static class TransactionRequest {
        private BigDecimal amount;
        private String description;
        private CurrentAccount currentAccount;
    }
}
