package za.co.entelect.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Customers extends IIdentifiableEntity {

    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime startDate;
    private String accountNumber;
    private Boolean active;
    private String identification;

    @OneToOne(cascade = CascadeType.ALL)
    private SavingsAccount savingsAccount;

    @OneToOne(cascade = CascadeType.ALL)
    private CurrentAccount currentAccount;

}
