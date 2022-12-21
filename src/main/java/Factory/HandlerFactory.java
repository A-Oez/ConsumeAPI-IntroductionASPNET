package Factory;
import CallData.Article.ArticleHandler;
import CallData.Customer.CustomerHandler;
import CallData.Order.OrderHandler;

public class HandlerFactory {

    public static IHandler getHandler(HandlerTypes types){

        switch (types){
            case Article:
                return new ArticleHandler();

            case Order:
                return new OrderHandler();

            case Customer:
                return new CustomerHandler();

            default:
                return null;
        }
    }

}

