package services;

import doa.ClientsDoa;
import models.Clients;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientsServiceTest {

    ClientsDoa clientsDoa = Mockito.mock((ClientsDoa.class));

    ClientsService clientsService;

    public ClientsServiceTest(){

        this.clientsService = new ClientsService((clientsDoa));
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createClient() {
        Clients expectedResult = new Clients(1, "New", "Client");

        clientsService.createClient();

        Mockito.verify(clientsDoa).createClient();
    }

    @Test
    void getAllClients() {
        List<Clients> Clients = new ArrayList<>();
        Clients.add(new Clients(1, "New", "Client"));
        Clients.add(new Clients(2, "New", "Client"));
        Clients.add(new Clients(3, "New", "Client"));
        List<Clients> expectedValues = Clients;
        Mockito.when(clientsDoa.getAllClients()).thenReturn(Clients);

        List<Clients> actualResult = clientsService.getAllClients();


        assertEquals(expectedValues, actualResult);
    }

    @Test
    void getOneClient() {
        Clients expectedResult = new Clients(1, "New", "Client");
        Mockito.when(clientsDoa.getOneClient(expectedResult.getId())).thenReturn(expectedResult);

        Clients actualResult = clientsService.getOneClient(expectedResult.getId());


        assertEquals(expectedResult,actualResult);

    }

    @Test
    void updateClient() {
        Integer clientId =1;

        clientsService.updateClient(1);


        Mockito.verify(clientsDoa).updateClient(clientId);
    }

    @Test
    void deleteClient() {
        Integer clientId =1;

        clientsService.deleteClient(1);


        Mockito.verify(clientsDoa).deleteClient(clientId);
    }
}