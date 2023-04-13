package za.co.entelect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.entelect.constants.CreateCustomerAndAccounts;
import za.co.entelect.dtos.currentAccount.CreateCurrentAccountDTO;
import za.co.entelect.dtos.customer.CreateCustomerDTO;
import za.co.entelect.dtos.customer.CustomerDTO;
import za.co.entelect.dtos.customer.UpdateCustomerDTO;
import za.co.entelect.dtos.savingsAccount.CreateSavingsAccountDTO;
import za.co.entelect.entities.CustomerSearchRequest;
import za.co.entelect.entities.Customers;
import za.co.entelect.services.CurrentAccountService;
import za.co.entelect.services.CustomersService;
import za.co.entelect.services.SavingsAccountService;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("customers")
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    @Autowired
    private CurrentAccountService currentAccountService;

    @Autowired
    private SavingsAccountService savingsAccountService;

    public CustomersController(CustomersService customersService) { this.customersService = customersService;}

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody CreateCustomerDTO customer) {
        CreateCurrentAccountDTO currentAccountDTO = new CreateCurrentAccountDTO();
        currentAccountDTO.setBalance(new BigDecimal("0.00"));
        currentAccountDTO.setCustomer(customer);
        currentAccountDTO.setAccountNumber(generateAccountNumber());

        CreateSavingsAccountDTO savingsAccountDTO = new CreateSavingsAccountDTO();
        savingsAccountDTO.setBalance(new BigDecimal("500.00"));
        savingsAccountDTO.setCustomer(customer);
        savingsAccountDTO.setAccountNumber(generateAccountNumber());

        customer.setCurrentAccount(currentAccountDTO);
        customer.setSavingsAccount(savingsAccountDTO);

        CustomerDTO savedCustomer = new CreateCustomerAndAccounts(customersService, currentAccountService, savingsAccountService)
                .createCustomerAndAccounts(customer, currentAccountDTO, savingsAccountDTO);

        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getCustomers() {
        List<Customers> customers = customersService.getCustomers();

        if(!customers.isEmpty()) {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        CustomerDTO customer = this.customersService.getCustomer(id);

        if(customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/search")
    public ResponseEntity<?> searchCustomers(@RequestBody CustomerSearchRequest searchRequest) {
        Customers customer = customersService.searchCustomers(searchRequest);

        if(customer != null) {
            return ResponseEntity.ok(customer);
        }

        return ResponseEntity.notFound().build();
    }

    private String generateAccountNumber() {
        String accountNumber = "";
        Random random = new Random();

        // Generate a 9-digit account number
        for (int i = 0; i < 9; i++) {
            accountNumber += random.nextInt(10);
        }

        return accountNumber;
    }
}
