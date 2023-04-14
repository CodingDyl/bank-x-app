package za.co.entelect.dtos.customer;

import lombok.Getter;
import lombok.Setter;
import za.co.entelect.dtos.currentAccount.CreateCurrentAccountDTO;
import za.co.entelect.dtos.currentAccount.CurrentAccountDTO;
import za.co.entelect.dtos.savingsAccount.CreateSavingsAccountDTO;
import za.co.entelect.dtos.savingsAccount.SavingsAccountDTO;
import za.co.entelect.entities.CurrentAccount;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class CreateCustomerDTO {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime startDate;
    private String accountNumber;
    private Boolean active;
    private String identification;

    private CreateSavingsAccountDTO savingsAccount;

    private CreateCurrentAccountDTO currentAccount;

    public boolean hasAllRequiredFields() {
        return email != null
                && firstName != null
                && lastName != null
                && startDate != null
                && accountNumber != null
                && identification != null
                && active != null
                && currentAccount != null
                && savingsAccount != null;
    }
}
