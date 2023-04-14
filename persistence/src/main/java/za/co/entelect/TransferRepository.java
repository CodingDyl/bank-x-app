package za.co.entelect;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.entelect.entities.Transfers;
@Repository
public interface TransferRepository extends CrudRepository<Transfers, Long> {
}
