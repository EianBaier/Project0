package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;
import models.Accounts;

import services.AccountsService;

import java.util.ArrayList;
import java.util.List;

import static controllers.ClientsController.clientsService;

public class AccountsController {

    static AccountsService accountsService = new AccountsService();


    public static void createAccount(Context context) throws JsonProcessingException {

        Integer ClientIdFk = Integer.parseInt(context.pathParam("id"));

        accountsService.createAccount(ClientIdFk);
        context.status(201);
        context.result("account added");
    }

    public static void getAllAccounts(Context context) throws JsonProcessingException {

        context.contentType("application/json");

        Integer ClientIdFk = Integer.parseInt(context.pathParam("id"));

        List<Accounts> accountslist = accountsService.getAllAccounts(ClientIdFk);


        String jsonString = new ObjectMapper().writeValueAsString(accountslist);

        //String jsonString = "this message";


        context.result(jsonString);
    }

    public static void getAllAccountsGreaterOrLessThanForACustomer(Context context) throws JsonProcessingException {

        context.contentType("application/json");

        Integer ClientIdFk = Integer.parseInt(context.pathParam("id"));

       String lowerValueString= context.queryParam("amountLessThan");

       Integer lowerValue = Integer.parseInt(lowerValueString);

       String greaterValueString = context.queryParam("amountGreaterThan");

       Integer greaterValue = Integer.parseInt(greaterValueString);



        List<Accounts> accountslist = accountsService.getAllAccountsGreaterOrLessThanForACustomer(ClientIdFk, lowerValue, greaterValue);




        String jsonString = new ObjectMapper().writeValueAsString(accountslist);

        //String jsonString = "this message";

        if (clientsService.getOneClient(ClientIdFk) == null) {
            context.status(404);
            context.result("Client with that id does not exist");

        } else {

        context.result(jsonString);}
    }

    public static void getASpecificAccount(Context context) throws JsonProcessingException {

        context.contentType("application/json");

        Integer ClientIdFk = Integer.parseInt(context.pathParam("id"));
        Integer accountNumber = Integer.parseInt(context.pathParam("accountNum"));

        List<Accounts> accountslist = accountsService.getASpecificAccount(ClientIdFk, accountNumber);

        List<Accounts> emptyList = new ArrayList<>();
        String jsonString = new ObjectMapper().writeValueAsString(accountslist);


        //String jsonString = "this message";

        if (clientsService.getOneClient(ClientIdFk) == null) {
            context.status(404);
            context.result("Client with that id does not exist");

        }else if (accountslist.size() == 0) {
                context.status(404);
                context.result("Account with that number does not exist");
        }else {


        context.result(jsonString);}
    }

    public static void updateAccount(Context context) throws JsonProcessingException {

        Integer ClientIdFk = Integer.parseInt(context.pathParam("id"));
        Integer accountNumber = Integer.parseInt(context.pathParam("accountNum"));

        if (clientsService.getOneClient(ClientIdFk) == null) {
            context.status(404);
            context.result("Client with that id does not exist");

        }else if (accountsService.getASpecificAccount(ClientIdFk, accountNumber).size() == 0) {
            context.status(404);
            context.result("Account with that number does not exist");
        }else {

            accountsService.updateAccount(ClientIdFk, accountNumber);
            context.result("Account " + accountNumber + " has been updated");}
    }

    public static void deleteAccount(Context context) throws JsonProcessingException {

        Integer ClientIdFk = Integer.parseInt(context.pathParam("id"));
        Integer accountNumber = Integer.parseInt(context.pathParam("accountNum"));

        if (clientsService.getOneClient(ClientIdFk) == null) {
            context.status(404);
            context.result("Client with that id does not exist");

        }else if (accountsService.getASpecificAccount(ClientIdFk, accountNumber).size() == 0) {
            context.status(404);
            context.result("Account with that number does not exist");
        }else {

            accountsService.deleteAccount(ClientIdFk, accountNumber);
            context.result("Account " + accountNumber + " has been deleted");}
    }

    public static void withdrawOrDeposit(Context context) throws JsonProcessingException {
        Accounts account = context.bodyAsClass(Accounts.class);

        Integer ClientIdFk = Integer.parseInt(context.pathParam("id"));
        Integer accountNumber = Integer.parseInt(context.pathParam("accountNum"));

        if (clientsService.getOneClient(ClientIdFk) == null) {
            context.status(404);
            context.result("Client with that id does not exist");

        }else if (accountsService.getASpecificAccount(ClientIdFk, accountNumber).size() == 0) {
            context.status(404);
            context.result("Account with that number does not exist");
        }else {

            accountsService.withdrawOrDeposit(ClientIdFk, accountNumber, account);
            context.result("Transaction Complete");}
    }

    public static void transfer(Context context) throws JsonProcessingException {
        Accounts account = context.bodyAsClass(Accounts.class);

        Integer ClientIdFk = Integer.parseInt(context.pathParam("id"));
        Integer accountNumber1 = Integer.parseInt(context.pathParam("accountNum"));
        Integer accountNumber2 = Integer.parseInt(context.pathParam("accountNum2"));
        if (clientsService.getOneClient(ClientIdFk) == null) {
            context.status(404);
            context.result("Client with that id does not exist");

        }else if (accountsService.getASpecificAccount(ClientIdFk, accountNumber1).size() == 0) {
            context.status(404);
            context.result("Account with that number does not exist");
        }else {

            accountsService.transfer(ClientIdFk, accountNumber1, accountNumber2, account);
            context.result("Transaction Complete");}
    }
}
