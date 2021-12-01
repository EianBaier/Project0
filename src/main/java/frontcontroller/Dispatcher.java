package frontcontroller;

import controllers.AccountsController;
import controllers.ClientsController;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Dispatcher {

    public Dispatcher(Javalin app){





        app.routes(() -> {


            path("clients", () -> {
                get(ClientsController::getAllClients);
                post(ClientsController::createClient);

                path("{id}", () ->{
                    get(ClientsController::getOneClient);
                    put(ClientsController::updateClient);
                    delete(ClientsController::deleteClient);

                    path("accounts", () ->{
                        post(AccountsController::createAccount);
                        get(AccountsController::getAllAccounts);
                        path("query", () ->{
                            get(AccountsController::getAllAccountsGreaterOrLessThanForACustomer);
                        });

                        path("{accountNum}", () ->{
                            get(AccountsController::getASpecificAccount);
                            put(AccountsController::updateAccount);
                            delete(AccountsController::deleteAccount);
                            patch(AccountsController::withdrawOrDeposit);

                            path("transfer/{accountNum2}", () ->{
                                patch(AccountsController::transfer);


                            });
                        });





                    });


                });
        });

        });


    }


}
