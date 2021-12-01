package services;

import doa.ClientsDoa;
import doa.ClientsDoaImplementation;
import io.javalin.http.Context;
import models.Clients;

import java.util.List;

public class ClientsService {
    ClientsDoa clientsDoa;


    // ClientsDoaImplementation clientsDoaImplementation;

    public ClientsService(ClientsDoa clientsDoa) {

        this.clientsDoa = clientsDoa;
    }

    public ClientsService() {

        this.clientsDoa = new ClientsDoaImplementation();
    }

    public void createClient(){
        clientsDoa.createClient();

    }

    public List<Clients> getAllClients() {

        return clientsDoa.getAllClients();
        // return null;

    }

    public Clients getOneClient(Integer id) {


       // if (clientsDoa.getOneClient(id) == null)
            //context.status(404);
            //context.result("Client with that id does not exist");

          //  return null;


            return clientsDoa.getOneClient(id);
        }

    public void updateClient(Integer clientId) {
        clientsDoa.updateClient(clientId);

    }

    public void deleteClient(Integer clientId) {
        clientsDoa.deleteClient(clientId);

    }
}



