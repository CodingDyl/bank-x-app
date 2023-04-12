package za.co.entelect.services;

import org.springframework.stereotype.Service;
import za.co.entelect.CustomerRepository;
import za.co.entelect.entities.CustomerSearchRequest;
import za.co.entelect.entities.Customers;
import za.co.entelect.entities.CustomerSearchType;

import java.util.*;
import java.util.function.Supplier;

@Service
public class CustomersService {

    private final CustomerRepository customerRepository;

    public CustomersService(CustomerRepository customerRepository) { this.customerRepository = customerRepository;}

    public Customers createCustomer(Customers customer) { return customerRepository.save(customer);}

    public List<Customers> getCustomers() {
        Iterable<Customers> customerIterable = customerRepository.findAll();

        List<Customers> result = new ArrayList<>();
        customerIterable.forEach(result::add);

        return result;
    }

    public Customers getCustomer(Long id) {
        Optional<Customers> customerOptional = customerRepository.findById(id);
        return customerOptional.orElse(null);
    }

    public Customers searchCustomers(CustomerSearchRequest searchRequest) {
        Map<CustomerSearchType, Supplier<Optional<Customers>>> searchStrategies = new HashMap<>();

        searchStrategies.put(CustomerSearchType.NAME_SEARCH, () -> customerRepository.findByFirstNameAndLastName(searchRequest.getFirstName(), searchRequest.getLastName()));
        searchStrategies.put(CustomerSearchType.ACCOUNT_NUMBER_SEARCH, () -> customerRepository.findByAccountNumber(searchRequest.getAccountNumber()));
        searchStrategies.put(CustomerSearchType.IDENTIFICATION_SEARCH, () -> customerRepository.findByIdentificationNumber(searchRequest.getIdentification()));

        Optional<Customers> customerOptional = searchStrategies.get(searchRequest.getSearchType()).get();

        return customerOptional.orElse(null);
    }
}
