package za.co.entelect.dtos.currentAccount;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UpdateCurrentAccountDTO {
    private BigDecimal balance;
}
