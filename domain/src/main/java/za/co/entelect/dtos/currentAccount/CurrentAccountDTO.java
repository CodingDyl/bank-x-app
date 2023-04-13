package za.co.entelect.dtos.currentAccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import za.co.entelect.entities.CurrentAccount;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CurrentAccountDTO {

    private Long id;

    private String accountNumber;

    private BigDecimal balance;

    public static CurrentAccountDTO fromEntity(CurrentAccount currentAccountEntity) {
        return CurrentAccountDTO.builder()
                .id(currentAccountEntity.getId())
                .accountNumber(currentAccountEntity.getAccountNumber())
                .balance(currentAccountEntity.getBalance())
                .build();
    }
}
