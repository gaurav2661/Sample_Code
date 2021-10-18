package springframework.brewery.web.services;

import springframework.brewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerID);

    CustomerDto saveCustomer(CustomerDto customerDto);

    void deleteById(UUID customerId);

    void updateCustomer(UUID customerId, CustomerDto customerDto);
}
