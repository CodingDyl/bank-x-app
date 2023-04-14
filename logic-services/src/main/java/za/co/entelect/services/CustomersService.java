package za.co.entelect.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.entelect.CurrentAccountRepository;
import za.co.entelect.CustomerRepository;
import za.co.entelect.SavingsAccountRepository;
import za.co.entelect.dtos.customer.CreateCustomerDTO;
import za.co.entelect.dtos.customer.CustomerDTO;
import za.co.entelect.dtos.customer.UpdateCustomerDTO;
import za.co.entelect.entities.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Supplier;

@Service
public class CustomersService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomersService(CustomerRepository customerRepository) { this.customerRepository = customerRepository;}

    public Customers createCustomer(CreateCustomerDTO createCustomerDTO) {
        Customers customer = new Customers();
        customer.setFirstName(createCustomerDTO.getFirstName());
        customer.setLastName(createCustomerDTO.getLastName());
        customer.setEmail(createCustomerDTO.getEmail());
        customer.setActive(true);
        customer.setStartDate(LocalDateTime.now());
        customer.setIdentification(createCustomerDTO.getIdentification());



        Customers savedCustomer = customerRepository.save(customer);


        return savedCustomer;
    }

    public List<Customers> getCustomers() {
        Iterable<Customers> customerIterable = customerRepository.findAll();

        List<Customers> result = new ArrayList<>();
        customerIterable.forEach(result::add);

        return result;
    }

    public CustomerDTO getCustomer(Long id) {
        Customers foundCustomer = customerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Customer with id " + id + " was not found")
        );

        return CustomerDTO.fromEntity(foundCustomer);
    }

    public CustomerDTO updateCustomer(Long id, UpdateCustomerDTO updateCustomerDTO) {
        Customers foundCustomer = customerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User with id " + id + " not found")
        );

        foundCustomer.setEmail(updateCustomerDTO.getEmail());
        foundCustomer.setActive(updateCustomerDTO.getActive());

        foundCustomer = customerRepository.save(foundCustomer);

        return CustomerDTO.fromEntity(foundCustomer);
    }

    public Customers searchCustomers(CustomerSearchRequest searchRequest) {
        Map<CustomerSearchType, Supplier<Optional<Customers>>> searchStrategies = new HashMap<>();

        searchStrategies.put(CustomerSearchType.NAME_SEARCH, () -> customerRepository.findByFirstNameAndLastName(searchRequest.getFirstName(), searchRequest.getLastName()));
        searchStrategies.put(CustomerSearchType.ACCOUNT_NUMBER_SEARCH, () -> customerRepository.findByAccountNumber(searchRequest.getAccountNumber()));

        Optional<Customers> customerOptional = searchStrategies.get(searchRequest.getSearchType()).get();

        return customerOptional.orElse(null);
    }
}
