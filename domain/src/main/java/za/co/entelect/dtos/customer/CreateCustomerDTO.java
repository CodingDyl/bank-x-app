package za.co.entelect.dtos.customer;

import lombok.Getter;
import lombok.Setter;

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

    public boolean hasAllRequiredFields() {
        return email != null
                && firstName != null
                && lastName != null
                && startDate != null
                && accountNumber != null
                && identification != null
                && active != null;
    }
}
