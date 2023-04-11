package za.co.entelect.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "id"))
@Table(name = "savingsAccount", schema = "db_bankX")
@Entity
public class SavingsAccount extends IIdentifiableEntity {

    private String accountNumber;
    private BigDecimal balance;
    private float interestReceived;

    /*@ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction_ref;*/

}
