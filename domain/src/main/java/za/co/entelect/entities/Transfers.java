package za.co.entelect.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Transfers extends IIdentifiableEntity {

    private LocalDateTime transferDate;
    private BigDecimal amount;

    @ManyToOne
    private SavingsAccount savingsAccount;

    @ManyToOne
    private CurrentAccount currentAccount;
}
