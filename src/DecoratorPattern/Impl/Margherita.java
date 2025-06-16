package DecoratorPattern.Impl;

import DecoratorPattern.Pizza;

public class Margherita implements Pizza {

    private final String description = "Margherita";
    private final double cost = 200.0;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
