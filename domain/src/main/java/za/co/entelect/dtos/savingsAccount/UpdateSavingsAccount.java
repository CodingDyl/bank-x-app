package za.co.entelect.dtos.savingsAccount;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UpdateSavingsAccount {
    private BigDecimal balance;
}
