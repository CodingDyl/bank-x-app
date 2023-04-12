package za.co.entelect.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Customers extends IIdentifiableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private Date startDate;
    private String accountNumber;
    private Boolean active;
    private String identification;

    @OneToOne
    @JoinColumn(name = "saving_account_id")
    private SavingsAccount sAccount;

    @OneToOne
    @JoinColumn(name = "current_account_id")
    private CurrentAccount cAccount;

}
