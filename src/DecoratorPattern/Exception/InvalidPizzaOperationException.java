package DecoratorPattern.Exception;

public class InvalidPizzaOperationException extends RuntimeException{

    public InvalidPizzaOperationException(String message){
        super(message);
    }
}
