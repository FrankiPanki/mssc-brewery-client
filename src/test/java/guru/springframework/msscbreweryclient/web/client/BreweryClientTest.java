package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getByIdBeer() {
        BeerDto beerDto = breweryClient.getByIdBeer(UUID.randomUUID());
        System.out.println(beerDto);
    }

    @Test
    void saveBeer() {
        URI uri = breweryClient.saveBeer(BeerDto.builder().beerName("Lagger").build());
        System.out.println(uri.toString());
    }

    @Test
    void updateBeer() {
        breweryClient.updateBeer(UUID.randomUUID(), BeerDto.builder().build());
    }

    @Test
    void delete() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getByIdCustomer() {
        CustomerDto save = breweryClient.getByIdCustomer(UUID.randomUUID());
        System.out.println(save.toString());
    }

    @Test
    void saveCustomer() {
        URI uri = breweryClient.saveCustomer(UUID.randomUUID(), CustomerDto.builder().name("Spanki").build());
        System.out.println(uri.toString());
    }

    @Test
    void updateCustomer() {
        breweryClient.updateCustomer(UUID.randomUUID(),CustomerDto.builder().name("Spanki").build());
    }

    @Test
    void deleteCustomer() {
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}