package com.example.Buoi5.services;

import com.example.Buoi5.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> listProduct = new ArrayList<>();

    public ProductService() {
//        this.listProduct.add(new Product(1, "Sản Phẩm 1", "1.jpg", 29312));
//        this.listProduct.add(new Product(2, "Sản Phẩm 2", "2.jpg", 124246));
    }

    public void add(Product newProduct) {
        int id = listProduct.size() + 1;
        newProduct.setId(id);
        listProduct.add(newProduct);
    }

    public List<Product> GetAll() {
        return listProduct;
    }

    public Product get(int id) {
        return listProduct.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void update(Product updatedProduct) {
        Product existingProduct = get(updatedProduct.getId());
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setImage(updatedProduct.getImage());
            existingProduct.setPrice(updatedProduct.getPrice());
        }
    }

    public void delete(int id) {
        listProduct.removeIf(p -> p.getId() == id);
    }
}