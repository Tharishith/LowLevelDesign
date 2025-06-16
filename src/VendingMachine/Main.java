package VendingMachine;

public class Main {
    public static void main(String[] args){

        VendingMachine vendingMachine = new VendingMachine();
        Product product = new Product(1,"milkShake",40);

        for(int i=1;i<=3; i++){
            vendingMachine.addProduct(product);
        }

        Product product1 = new Product(2,"Biryani",120);

        for(int i=1;i<=3;i++){
            vendingMachine.addProduct(product1);
        }

        vendingMachine.insertCoin(10.0);
        vendingMachine.insertCoin(30.0);
        // vendingMachine.insertCoin(2.0);
        vendingMachine.pressButton(1);

        vendingMachine.insertCoin(40.0);
        vendingMachine.pressButton(1);

//        vendingMachine.insertCoin(7.0);
//        vendingMachine.pressButton(2);
    }
}
