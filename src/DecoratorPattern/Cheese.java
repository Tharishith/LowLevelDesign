package DecoratorPattern;

public class Cheese extends ToppingDecorator{

    private final String  toppingName = "Cheese";
    private final double toppingCost = 20.0;

    public Cheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return getPizza().getDescription() + " , "+ toppingName;
    }

    @Override
    public double getCost() {
        return getPizza().getCost() + toppingCost;
    }
}
