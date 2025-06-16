package VendingMachine;

public class NoCoinInsertedState implements State{

    VendingMachine vendingMachine;

    public NoCoinInsertedState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(double amount) {
        vendingMachine.setAmount(amount);
        vendingMachine.setCurrentState(new CoinInsertedState(vendingMachine));
    }

    @Override
    public void pressButton(int aisleNumber) {
        throw new IllegalStateException("Cannot select Product without inserting coin");
    }

    @Override
    public void dispenseProduct(int aisleNumber) {
        throw new IllegalStateException("Cannot Dispense Product without inserting coin");
    }
}
