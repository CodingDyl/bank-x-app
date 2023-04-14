package za.co.entelect;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.entelect.entities.Transactions;

@Repository
public interface TransactionRepository extends CrudRepository<Transactions, Long> {
}
