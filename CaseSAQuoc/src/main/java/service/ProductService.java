package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void create(Product product);
    Product findById(String id);
    void update(String id, Product product);
    void remove(String id);
}
