package za.co.entelect.entities;

import lombok.Data;

@Data
public class CustomerSearchRequest {
    private CustomerSearchType searchType;
    private String firstName;
    private String lastName;
    private String accountNumber;
}
