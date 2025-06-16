package VendingMachine;

public class VendingMachine {

    private State currentState;
    private Inventory inventory;
    private double amount;
    private static final int AISLE_COUNT = 10;

    public VendingMachine(){
        currentState = new NoCoinInsertedState(this);
        amount = 0.0;
        inventory = new Inventory(AISLE_COUNT);
    }

    public boolean hasSufficientAmount(double currentAmount){
        return (currentAmount <= this.amount);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void insertCoin(double amount){
        this.currentState.insertCoin(amount);
        System.out.println("The coin is inserted with amount : "+ amount);
    }

    public void pressButton(int aisleNumber){
        this.currentState.pressButton(aisleNumber); // after the press button dispense the product
        this.currentState.dispenseProduct(aisleNumber);
    }

    public State getCurreentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public void addProduct(Product product){
        try{
            this.getInventory().addProduct(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public State getCurrentState() {
        return currentState;
    }
}
