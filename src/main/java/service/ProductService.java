package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    Product getProduct(int id);
    void delete(int id);
    void addProduct(Product product);
    void updateProduct(Product product);
}
