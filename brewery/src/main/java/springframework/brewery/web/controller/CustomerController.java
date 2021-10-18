package springframework.brewery.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springframework.brewery.web.model.BeerDto;
import springframework.brewery.web.model.CustomerDto;
import springframework.brewery.web.services.CustomerService;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerID}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerID){
        return new ResponseEntity<>(customerService.getCustomerById(customerID), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity getCustomer(@Valid @RequestBody CustomerDto customerDto){
        CustomerDto savedCustomerDto = customerService.saveCustomer(customerDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location","Localhost:8080/api/v1/customer/getCustomer"+savedCustomerDto.getId().toString());
        return new ResponseEntity(httpHeaders,HttpStatus.CREATED);
    }
    @PutMapping("/updateCustomer/{customerId}")
    public ResponseEntity handleUpdateBeer(@PathVariable UUID customerId,@Valid @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId,customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/deleteCustomer/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable UUID customerId)
    {
        customerService.deleteById(customerId);
    }



}
