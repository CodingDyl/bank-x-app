package za.co.entelect.entities;

import jakarta.persistence.*;
import lombok.*;
import za.co.entelect.dtos.customer.CustomerDTO;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CurrentAccount extends IIdentifiableEntity {

    private String accountNumber;

    private BigDecimal balance;

    @OneToOne
    private Customers customers;
}
