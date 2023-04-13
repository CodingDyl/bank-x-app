package za.co.entelect.dtos.savingsAccount;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateSavingsAccountDTO {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;

    public boolean hasAllRequiredFields() {
        return id != null
                && accountNumber != null
                && balance != null;
    }
}
