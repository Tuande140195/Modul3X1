package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

    private static Map<String, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put("SP001", new Product("1","Iphone 11", 100.0, 100, "gold", "256G" , "Iphone"));
        productMap.put("SP002", new Product("2","Iphone 12", 120.0, 100, "gold", "564G" , "Iphone"));

        productMap.put("SP003", new Product("3","Samsung S21", 200.0, 100, "black", "256G" , "Samsung"));
        productMap.put("SP004", new Product("4","Oppo S20", 180.0, 100, "white", "256G" , "Oppo"));

    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void create(Product product) {
          if (!productMap.containsKey(product.getId())){
              productMap.put(product.getId(), product);
          }

    }

    @Override
    public Product findById(String id) {
       if (productMap.containsKey(id)){
           return productMap.get(id);
       }else {
           return null;
       }
    }

    @Override
    public void update(String id, Product product) {
       if (productMap.containsKey(product.getId())){
           productMap.put(product.getId(), product);
       }
    }

    @Override
    public void remove(String id) {
         if (productMap.containsKey(id)){
             productMap.remove(id);
         }
    }
}
