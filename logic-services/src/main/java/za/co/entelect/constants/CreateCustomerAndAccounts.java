package za.co.entelect.constants;

import org.springframework.beans.factory.annotation.Autowired;
import za.co.entelect.dtos.currentAccount.CreateCurrentAccountDTO;
import za.co.entelect.dtos.currentAccount.CurrentAccountDTO;
import za.co.entelect.dtos.customer.CreateCustomerDTO;
import za.co.entelect.dtos.customer.CustomerDTO;
import za.co.entelect.dtos.savingsAccount.CreateSavingsAccountDTO;
import za.co.entelect.dtos.savingsAccount.SavingsAccountDTO;
import za.co.entelect.services.CurrentAccountService;
import za.co.entelect.services.CustomersService;
import za.co.entelect.services.SavingsAccountService;

public class CreateCustomerAndAccounts {

    @Autowired
    private CustomersService customerService;

    @Autowired
    private CurrentAccountService currentAccountService;

    @Autowired
    private SavingsAccountService savingsAccountService;

    public CreateCustomerAndAccounts(CustomersService customerService, CurrentAccountService currentAccountService, SavingsAccountService savingsAccountService) {
        this.customerService = customerService;
        this.currentAccountService = currentAccountService;
        this.savingsAccountService = savingsAccountService;
    }

    public CustomerDTO createCustomerAndAccounts(CreateCustomerDTO createCustomerDTO, CreateCurrentAccountDTO createCurrentAccountDTO, CreateSavingsAccountDTO createSavingsAccountDTO) {

        //create customer
        CustomerDTO customerDTO = CustomerDTO.fromEntity(customerService.createCustomer(createCustomerDTO));

        //create current account for customer
        CurrentAccountDTO currentAccountDTO = currentAccountService.createCurrentAccount(createCurrentAccountDTO);

        //create savings account for customer
        SavingsAccountDTO savingsAccountDTO = savingsAccountService.createSavingsAccount(createSavingsAccountDTO);

        return customerDTO;
    }

}
