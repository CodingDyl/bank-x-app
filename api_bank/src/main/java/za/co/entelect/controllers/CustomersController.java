package za.co.entelect.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.entelect.entities.CustomerSearchRequest;
import za.co.entelect.entities.Customers;
import za.co.entelect.services.CustomersService;

import java.util.*;

@RestController
@RequestMapping("customers")
public class CustomersController {

    private final CustomersService customersService;

    public CustomersController(CustomersService customersService) { this.customersService = customersService;}

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Customers customer) {
        final Customers savedCustomer = customersService.createCustomer(customer);

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
        Customers customer = this.customersService.getCustomer(id);

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
}
