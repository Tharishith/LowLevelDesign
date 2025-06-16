package DecoratorPattern.Impl;

import DecoratorPattern.Pizza;

public class Farmhouse implements Pizza {

    private final String description = "Farmhouse";
    private final double cost = 180.0;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
