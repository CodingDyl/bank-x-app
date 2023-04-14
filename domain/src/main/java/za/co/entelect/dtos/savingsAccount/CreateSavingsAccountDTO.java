package za.co.entelect.dtos.savingsAccount;

import lombok.Getter;
import lombok.Setter;
import za.co.entelect.dtos.customer.CreateCustomerDTO;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateSavingsAccountDTO {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;

    private CreateCustomerDTO customer;

    public boolean hasAllRequiredFields() {
        return id != null
                && accountNumber != null
                && balance != null
                && customer != null;
    }
}
