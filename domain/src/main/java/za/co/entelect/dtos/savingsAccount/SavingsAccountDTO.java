package za.co.entelect.dtos.savingsAccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import za.co.entelect.entities.SavingsAccount;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SavingsAccountDTO {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;

    public static SavingsAccountDTO fromEntity(SavingsAccount savingsAccountEntity) {
        return SavingsAccountDTO.builder()
                .id(savingsAccountEntity.getId())
                .accountNumber(savingsAccountEntity.getAccountNumber())
                .balance(savingsAccountEntity.getBalance())
                .build();
    }
}
