package za.co.entelect;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.entelect.entities.Customers;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customers, Long> {

    Optional<Customers> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<Customers> findByAccountNumber(String accountNumber);

    Optional<Customers> findByIdentificationNumber(String identification);

}
