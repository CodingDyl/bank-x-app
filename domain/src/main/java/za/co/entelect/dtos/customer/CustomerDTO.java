package za.co.entelect.dtos.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import za.co.entelect.entities.Customers;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime startDate;
    private String accountNumber;
    private Boolean active;
    private String identification;

    public static CustomerDTO fromEntity(Customers customerEntity) {
        return CustomerDTO.builder()
                .id(customerEntity.getId())
                .firstName(customerEntity.getFirstName())
                .lastName(customerEntity.getLastName())
                .email(customerEntity.getEmail())
                .startDate(customerEntity.getStartDate())
                .accountNumber(customerEntity.getAccountNumber())
                .active(customerEntity.getActive().booleanValue())
                .identification(customerEntity.getIdentification())
                .build();
    }
}
