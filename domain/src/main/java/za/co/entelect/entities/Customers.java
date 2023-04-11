package za.co.entelect.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverride(name = "id", column = @Column(name = "id"))
@Table(name = "customers", schema = "db-bankX")
@Entity
public class Customers extends IIdentifiableEntity {

    private String firstName;
    private String lastName;
    private String email;
    private Date startDate;
    private String accountNumber;
    private Boolean active;

    /*@OneToOne
    @JoinColumn(name = "saving_account_id")
    private SavingsAccount sAccount;*/

    /*@OneToOne
    @JoinColumn(name = "current_acccount_id")
    private CurrentAccount cAccount;*/

}
