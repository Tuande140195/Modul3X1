package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void create(Product product);
    Product findById(String id);
    int update( Product product);
    void remove(String id);
}
