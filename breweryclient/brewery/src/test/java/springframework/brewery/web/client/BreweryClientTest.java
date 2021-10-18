package springframework.brewery.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springframework.brewery.web.model.BeerDto;
import springframework.brewery.web.model.CustomerDto;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;
    @Test
    void getBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }
    @Test
    void SaveNewBeer(){
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).name("Kingfisher").beerStyle("9089").build();
        URI uri = breweryClient.saveNewBeer(beerDto);
        System.out.printf(uri.toString());
    }
    @Test
    void updateBeer(){
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).name("Kingfisher").beerStyle("9089").build();
        breweryClient.UpdateBeer(UUID.randomUUID(),beerDto);
    }
    @Test
    void deleteBeer(){
        breweryClient.deleteBeer(UUID.randomUUID());
    }
    @Test
    void getCustomerById(){
        CustomerDto customerDto = breweryClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }
    @Test
    void saveNewCustomer(){
        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).name("GAURAV").build();
        URI uri=breweryClient.saveNewCustomer(customerDto);
        System.out.println(uri.toString());
    }
    @Test
    void updateCustomer(){
        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).name("GAURAV").build();
        breweryClient.updateCustomer(UUID.randomUUID(),customerDto);
    }
    @Test
    void deleteCustomer(){
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}