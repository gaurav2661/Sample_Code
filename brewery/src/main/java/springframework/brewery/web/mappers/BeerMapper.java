package springframework.brewery.web.mappers;
import org.mapstruct.Mapper;
import springframework.brewery.domain.Beer;
import springframework.brewery.web.model.BeerDto;

@Mapper
public interface BeerMapper {
    BeerDto beerToBeerBto(Beer beer);

    Beer beerDtoTOBeer(BeerDto beerDto);
}
