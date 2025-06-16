package DecoratorPattern;

import DecoratorPattern.Exception.InvalidPizzaOperationException;

public abstract class ToppingDecorator implements Pizza{

    private final Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        if(pizza == null){
            throw new InvalidPizzaOperationException("Pizza Cannot be null");
        }
        this.pizza = pizza;
    }
    protected Pizza getPizza(){
        return this.pizza;
    }

}
