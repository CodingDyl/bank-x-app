package za.co.entelect;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.entelect.entities.CurrentAccount;

@Repository
public interface CurrentAccountRepository extends CrudRepository<CurrentAccount, Long> {

}
