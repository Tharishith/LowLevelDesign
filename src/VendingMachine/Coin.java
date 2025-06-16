package VendingMachine;

public enum Coin {
    PENNY(1),
    DIME(10),
    QUARTER(25);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
