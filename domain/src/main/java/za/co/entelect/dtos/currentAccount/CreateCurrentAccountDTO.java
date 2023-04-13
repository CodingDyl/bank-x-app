package za.co.entelect.dtos.currentAccount;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateCurrentAccountDTO {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;

    public boolean hasAllRequiredFields() {
        return id != null
                && accountNumber != null
                && balance != null;
    }
}
