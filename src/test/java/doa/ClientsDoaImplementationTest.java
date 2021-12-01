package doa;

import models.Clients;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.H2Util;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientsDoaImplementationTest {
    ClientsDoa clientsDoa;

    public ClientsDoaImplementationTest(){
        this.clientsDoa = new ClientsDoaImplementation(H2Util.url, H2Util.username,H2Util.password);
    }

    @BeforeEach
    void setUp() {
        H2Util.createTable();
    }

    @AfterEach
    void tearDown() {
        H2Util.dropTable();
    }

    @Test
    void createClient() {
        List<Clients> expectedResult = new ArrayList();
        expectedResult.add(new Clients(1, "John", "Smith"));
        expectedResult.add(new Clients(2, "Tim", "Jones"));
        expectedResult.add(new Clients(3, "Mary", "Black"));
        clientsDoa.createClient();
        clientsDoa.createClient();
        clientsDoa.createClient();


        Integer actualResult = clientsDoa.getAllClients().size();


        assertEquals(expectedResult.size(),actualResult);
    }

    @Test
    void getAllClients() {
        List<Clients> expectedResult = new ArrayList<>();
        expectedResult.add(new Clients(1, "New", "Client"));
        expectedResult.add(new Clients(2, "New", "Client"));
        expectedResult.add(new Clients(3, "New", "Client"));
        clientsDoa.createClient();
        clientsDoa.createClient();
        clientsDoa.createClient();


        Integer actualResult = clientsDoa.getAllClients().size();


        assertEquals(expectedResult.size(),actualResult);
    }

    @Test
    void getOneClient() {
        List<Clients> expectedResult = new ArrayList<>();
        expectedResult.add(new Clients(1, "New", "Client"));
        expectedResult.add(new Clients(2, "User", "From Postman"));
        expectedResult.add(new Clients(3, "New", "Client"));
        clientsDoa.createClient();
        clientsDoa.createClient();
        clientsDoa.createClient();


        Clients actualResult = clientsDoa.getOneClient(2);


        assertEquals(expectedResult.get(1),actualResult);

    }

    @Test
    void updateClient() {
        Clients clientToPass = new Clients(1, "New", "Client");
        Clients expectedResult = new Clients(1,"Updated","Name");
        clientsDoa.createClient();

        Clients actualResult = clientsDoa.getOneClient(1);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void deleteClient() {
        List<Clients> expectedResult = new ArrayList<>();
        expectedResult.add(new Clients(1, "New", "Client"));
        expectedResult.add(new Clients(2, "New", "Client"));
        expectedResult.add(new Clients(3, "New", "Client"));
        clientsDoa.createClient();
        clientsDoa.createClient();
        clientsDoa.createClient();


        clientsDoa.deleteClient(2);
        expectedResult.remove(1);
        Integer actualResult = clientsDoa.getAllClients().size();


        assertEquals(expectedResult.size(),actualResult);
    }
}