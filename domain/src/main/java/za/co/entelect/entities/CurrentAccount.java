package za.co.entelect.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
public class CurrentAccount extends IIdentifiableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;

    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transactions transaction_ref;
}
