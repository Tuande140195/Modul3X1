package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{

    private static Map<String, Product> products;

    static {
        products = new HashMap<>();
        products.put("Sp001",new Product("SP001","Iphone X", 15000000, "2020-1-1"));
        products.put("Sp002",new Product("SP002","Iphone 11", 20000000, "2022-2-1"));
        products.put("Sp003",new Product("SP003","Iphone 13", 35000000, "2022-1-1"));



    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
       products.put(product.getId(),product);
    }

    @Override
    public Product findById(String id) {
        return products.get(id);
    }

    @Override
    public void update(String id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(String id) {
        products.remove(id);
    }
}
