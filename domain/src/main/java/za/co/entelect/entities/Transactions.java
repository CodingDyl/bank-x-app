package za.co.entelect.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Transactions extends IIdentifiableEntity {
    private LocalDateTime transactionDate;
    private BigDecimal amount;
    private String description;
}
