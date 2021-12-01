package controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;
import models.Clients;

import services.ClientsService;

import java.util.List;

public class ClientsController {

    static ClientsService clientsService = new ClientsService();

    public static void createClient(Context context) throws JsonProcessingException {

        //Clients client = context.bodyAsClass(Clients.class);

        /*
        * "firstName": "User",
           "lastName": "From Postman"
           *
           *
        * */

        clientsService.createClient();
        context.status(201);
        context.result("client added");
    }

    public static void getAllClients(Context context) throws JsonProcessingException {

        context.contentType("application/json");

        List<Clients> clientsList = clientsService.getAllClients();


       String jsonString = new ObjectMapper().writeValueAsString(clientsList);

        //String jsonString = "this message";

        context.result(jsonString);
    }


    public static void getOneClient(Context context) throws JsonProcessingException {

        context.contentType("application/json");

        Integer ClientId = Integer.parseInt(context.pathParam("id"));

        Clients client = clientsService.getOneClient(ClientId);

        if (client == null) {
            context.status(404);
            context.result("Client with that id does not exist");

        } else {


            String jsonString = new ObjectMapper().writeValueAsString(client);

            //String jsonString = "this message";

            context.result(jsonString);
        }
    }
    public static void updateClient(Context context) throws JsonProcessingException {

        Integer clientId = Integer.parseInt(context.pathParam("id"));

        if (clientsService.getOneClient(clientId) == null) {
            context.status(404);
            context.result("Client with that id does not exist");
        }else {
            clientsService.updateClient(clientId);
            context.result("The client with id " + clientId + " has been updated");
        }
    }

    public static void deleteClient(Context context) throws JsonProcessingException {

        Integer clientId = Integer.parseInt(context.pathParam("id"));

        if (clientsService.getOneClient(clientId) == null) {
            context.status(404);
            context.result("Client with that id does not exist");
        }else {
            clientsService.deleteClient(clientId);
            context.status(205);
            context.result("The client with id " + clientId + " has been deleted");
        }
    }
}
