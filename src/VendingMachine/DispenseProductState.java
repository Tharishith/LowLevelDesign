package VendingMachine;

public class DispenseProductState implements State {

    VendingMachine vendingMachine;

    public DispenseProductState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(double amount) {
        throw new IllegalStateException("Coin cannot be inserted");
    }

    @Override
    public void pressButton(int aisleNumber) {
        throw new IllegalStateException("Product is getting dispensed");
    }

    @Override
    public void dispenseProduct(int aisleNumber) {
        Inventory inventory = vendingMachine.getInventory();
        Product product = inventory.getProduct(aisleNumber);

        double change = vendingMachine.getAmount()-product.getPrice();
        inventory.deductProduct(aisleNumber);
        vendingMachine.setAmount(0);
        vendingMachine.setCurrentState(new NoCoinInsertedState(vendingMachine));

        System.out.println(" Product with Id : " + product.getId() + " is dispensed ");
    }
}
