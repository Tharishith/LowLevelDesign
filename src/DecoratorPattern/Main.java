package DecoratorPattern;

import DecoratorPattern.Exception.InvalidPizzaOperationException;
import DecoratorPattern.Impl.Margherita;
import DecoratorPattern.Impl.VegDelight;

public class Main {
    public static void main(String[] args){

        try{
            Pizza pizza = new Jalapeno(new Cheese(new VegDelight()));

            System.out.println("Pizza 1: " + pizza.getDescription());
            System.out.println("Cost: " + pizza.getCost());

            Pizza pizza1 = new Jalapeno(new Margherita());
            System.out.println("Pizza 1: " + pizza1.getDescription());
            System.out.println("Cost:  " + pizza1.getCost());
        } catch (InvalidPizzaOperationException e) {
            throw new RuntimeException(e);
        }
    }
}
