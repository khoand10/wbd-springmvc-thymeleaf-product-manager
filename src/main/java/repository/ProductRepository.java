package repository;

import model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProduct();
    Product getProduct(int id);
    void delete(int id);
    void addProduct(Product product);
    void updateProduct(Product product);

}
