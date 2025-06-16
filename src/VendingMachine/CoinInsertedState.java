package VendingMachine;

public class CoinInsertedState implements State{

    VendingMachine vendingMachine;

    public CoinInsertedState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void insertCoin(double amount) {
        vendingMachine.setAmount(vendingMachine.getAmount()+ amount);
    }

    @Override
    public void pressButton(int aisleNumber) {
        Inventory inventory = vendingMachine.getInventory();
        Product product = inventory.getProduct(aisleNumber);
        if(!vendingMachine.hasSufficientAmount(product.getPrice()))
            throw new IllegalStateException("No Sufficient Money ");

        if(!inventory.checkProductIsAvailable(product.getId()))
            throw new IllegalStateException("The product is not Available");


        vendingMachine.setCurrentState(new DispenseProductState(vendingMachine));
    }

    @Override
    public void dispenseProduct(int aisleNumber) {
        throw new IllegalStateException("Product cannot be dispensed without selection");
    }
}
