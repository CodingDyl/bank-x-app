package za.co.entelect.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverride(name = "id", column = @Column(name = "id"))
@Table(name = "currentAccount", schema = "db_bankX")
@Entity
public class CurrentAccount extends IIdentifiableEntity {
    private String accountNumber;
    private BigDecimal balance;

    /*@ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction_ref;*/
}
