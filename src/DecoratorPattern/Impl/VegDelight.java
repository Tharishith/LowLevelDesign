package DecoratorPattern.Impl;

import DecoratorPattern.Pizza;

public class VegDelight implements Pizza {

    private final String description = "VegDelight";
    private final double cost = 150.0;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
