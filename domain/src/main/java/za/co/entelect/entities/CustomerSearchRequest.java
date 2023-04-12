package za.co.entelect.entities;

import lombok.Data;

@Data
public class CustomerSearchRequest {
    private SearchType searchType;
    private String firstName;
    private String lastName;
    private String accountNumber;
    private String identification;
}
