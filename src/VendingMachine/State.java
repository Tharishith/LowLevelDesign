package VendingMachine;

public interface State {
    public void insertCoin(double amount);
    public void pressButton(int aisleNumber);
    public void dispenseProduct(int aisleNumber);

}
