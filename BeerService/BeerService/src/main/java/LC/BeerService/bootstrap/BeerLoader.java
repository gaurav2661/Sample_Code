package LC.BeerService.bootstrap;

import LC.BeerService.domain.Beer;
import LC.BeerService.repository.BeerRepository;
import LC.BeerService.web.model.beerStyleEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {


    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
    }

    private void loadBeerData() {
        if(beerRepository.count()==0){
            beerRepository.save(Beer.builder()
                    .beerName("Mango bobs")
                    .beerStyle(beerStyleEnum.IPA)
                    .quantityToBrew(200)
                    .minOnHand(20)
                    .upc(337010000001L)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle(beerStyleEnum.PALE_ALE)
                    .quantityToBrew(200)
                    .minOnHand(20)
                    .upc(337010000003L)
                    .price(new BigDecimal("11.75"))
                    .build());
        }
        System.out.println("loaded beers"+beerRepository.count());
    }
}
