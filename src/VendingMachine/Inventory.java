package VendingMachine;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Inventory {
    private Map<Integer,Product> aisleNumToProductMap;
    private Map<Integer,Integer> productIdToCountMap;
    Queue<Integer> availableAisle;

    public Inventory(int aisleCount){
        availableAisle = new LinkedList<>();
        for(int i=1;i<aisleCount;i++)
            availableAisle.add(i);

        aisleNumToProductMap = new HashMap<>();
        productIdToCountMap = new HashMap<>();
    }

    public void addProduct(Product product) throws Exception{
        int productId = product.getId();
        int productCount = productIdToCountMap.getOrDefault(productId,0);
        if(productCount == 0){
            if(availableAisle.isEmpty())
                throw new Exception("Out of Space");

            aisleNumToProductMap.put(availableAisle.poll(),product);
        }
        productIdToCountMap.put(productId,productCount+1);
    }

    public void deductProduct(int aisleNumber){
        int productId = aisleNumToProductMap.get(aisleNumber).getId();
        int productCount = productIdToCountMap.getOrDefault(productId,0)-1;
        if(productCount ==  0){
            productIdToCountMap.remove(productId);
            aisleNumToProductMap.remove(aisleNumber);
            availableAisle.add(aisleNumber);
        }
        else{
            productIdToCountMap.put(productId,productCount-1);
        }
    }

    public Product getProduct(int aisleNumber){
        return aisleNumToProductMap.get(aisleNumber);
    }

    public boolean checkProductIsAvailable(int productId){
        int count = productIdToCountMap.getOrDefault(productId,0);
        return count > 0;
    }

}
