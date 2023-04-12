package za.co.entelect.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverride(name = "id", column = @Column(name = "id"))
@Table(name = "transactions", schema = "db_bankX")
@Entity
public class Transactions extends IIdentifiableEntity {
    private Date transactionDate;
    private BigDecimal amount;
    private String description;

    @OneToMany
    private Customers customerId;
}
