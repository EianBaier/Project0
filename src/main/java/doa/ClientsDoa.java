package doa;

import models.Clients;

import java.util.List;

public interface ClientsDoa {

    void createClient();
    List<Clients> getAllClients();
    Clients getOneClient(Integer ClientId);
    void updateClient(Integer clientId);
    void deleteClient(Integer clientId);

}
