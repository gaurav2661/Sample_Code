package springframework.brewery.web.model.V2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDtoV2 {
    private UUID id;//UUID (Universally Unique Identifier) has a value like :123e4567-e89b-12d3-a456-556642440000
    private String name;
    private BeerStyleEnum beerStyle;
    private Long upc;
}
