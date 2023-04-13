package za.co.entelect.dtos.currentAccount;

import lombok.Getter;
import lombok.Setter;
import za.co.entelect.dtos.customer.CreateCustomerDTO;
import za.co.entelect.entities.Customers;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateCurrentAccountDTO {
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
