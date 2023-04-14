package za.co.entelect.dtos.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCustomerDTO {
    private String email;
    private Boolean active;
}
