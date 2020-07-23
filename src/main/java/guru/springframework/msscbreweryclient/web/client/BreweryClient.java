package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
// hace que falle si no se conmfiguran los campos
public class BreweryClient {

    public final String API_PATH_V1_BEER = "/api/v1/beer/";
    public final String API_PATH_V1_CUSTOMER = "/api/v1/customer/";
    private String apihost;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public BeerDto getByIdBeer(UUID uuid) {
        return restTemplate.getForObject(apihost + API_PATH_V1_BEER + uuid.toString(), BeerDto.class);
    }

    public URI saveBeer(BeerDto beerDto) {
        return restTemplate.postForLocation(apihost + API_PATH_V1_BEER, beerDto);
    }

    public void updateBeer(UUID uuid, BeerDto beerDto){
        restTemplate.put(apihost + API_PATH_V1_BEER + uuid.toString(), beerDto);
    }

    public void deleteBeer(UUID uuid){
        restTemplate.delete(apihost + API_PATH_V1_BEER + "/" + uuid.toString(), uuid);
    }

    public CustomerDto getByIdCustomer(UUID uuid){
        return restTemplate.getForObject(apihost + API_PATH_V1_CUSTOMER + uuid.toString(),CustomerDto.class);
    }

    public URI saveCustomer(UUID uuid, CustomerDto customerDto){
        return restTemplate.postForLocation(apihost + API_PATH_V1_CUSTOMER + uuid.toString(), customerDto);
    }

    public void updateCustomer(UUID uuid, CustomerDto customerDto){
        restTemplate.put(apihost + API_PATH_V1_CUSTOMER + uuid.toString(),customerDto);
    }

    public void deleteCustomer(UUID uuid){
        restTemplate.delete(apihost + API_PATH_V1_CUSTOMER + uuid.toString());
    }
}
