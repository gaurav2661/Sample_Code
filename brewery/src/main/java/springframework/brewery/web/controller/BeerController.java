package springframework.brewery.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springframework.brewery.web.model.BeerDto;
import springframework.brewery.web.model.CustomerDto;
import springframework.brewery.web.services.BeerService;
import springframework.brewery.web.services.CustomerService;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;


    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity getCustomer(@Valid @RequestBody BeerDto beerDto){
        BeerDto beerDto1 = beerService.saveBeer(beerDto);

        HttpHeaders httpHeaders = new HttpHeaders();
       httpHeaders.add("Location","http://localhost:8080/api/v1/beer/getBeer"+beerDto1.getId());
        return new ResponseEntity(httpHeaders,HttpStatus.CREATED);
    }
    @PutMapping("/updateBeer/{beerId}")
    public ResponseEntity handleUpdateBeer(@PathVariable UUID beerId,@Valid @RequestBody BeerDto beerDto){
        beerService.updateBeer(beerId,beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/deleteBeer/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID beerId)
    {
        beerService.deleteById(beerId);
    }


}
