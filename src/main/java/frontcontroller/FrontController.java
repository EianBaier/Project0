package frontcontroller;

import io.javalin.Javalin;

public class FrontController {

    public FrontController(Javalin app){


        app.exception(NumberFormatException.class, ((e, context) -> {
            context.result("Invalid input....Please type a number");
        }));




        new Dispatcher(app);


    }
}
