package springframework.brewery.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import springframework.brewery.web.model.BeerDto;
import springframework.brewery.web.model.CustomerDto;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "spring.brewery",ignoreUnknownFields = false)
public class BreweryClient {
    private String apiHost;
    private final RestTemplate restTemplate;
    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
    public BeerDto getBeerById(UUID beerId){
        return restTemplate.getForObject(apiHost+"/api/v1/beer/"+beerId.toString(),BeerDto.class);
    }
    public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apiHost+"/api/v1/beer",beerDto);
    }
    public void UpdateBeer(UUID beerId,BeerDto beerDto){
        restTemplate.put(apiHost+"/api/v1/beer/updateBeer/"+beerId.toString(),beerDto);
    }
    public void deleteBeer(UUID beerId){
        restTemplate.delete(apiHost+"/api/v1/beer/deleteBeer/"+beerId.toString());
    }
    public CustomerDto  getCustomerById(UUID customerId){
        return restTemplate.getForObject(apiHost+"/api/v1/customer/"+customerId.toString(),CustomerDto.class);
    }
    public URI saveNewCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(apiHost+"/api/v1/customer",customerDto);
    }
    public void updateCustomer(UUID customerId,CustomerDto customerDto){
        restTemplate.put(apiHost+"/api/v1/customer/updateCustomer/"+customerId.toString(),customerDto);
    }
    public void deleteCustomer(UUID customerId){
        restTemplate.delete(apiHost+"/api/v1/customer/deleteCustomer/"+customerId.toString());
    }

}
