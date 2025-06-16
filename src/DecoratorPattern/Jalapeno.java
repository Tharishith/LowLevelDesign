package DecoratorPattern;

public class Jalapeno extends ToppingDecorator{

    private final String toppingName = "Jalapeno";
    private final double toppingCost = 20.0;

    public Jalapeno(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getDescription() {
        return getPizza().getDescription() + " , " + toppingName;
    }

    @Override
    public double getCost() {
        return getPizza().getCost() + toppingCost;
    }
}
