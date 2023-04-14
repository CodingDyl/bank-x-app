package za.co.entelect;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.entelect.entities.SavingsAccount;

import java.util.Optional;

@Repository
public interface SavingsAccountRepository extends CrudRepository<SavingsAccount, Long> {
    Optional<SavingsAccount> findByAccountNumber(String accountNumber);
}
