package com.jarbas.ProductCrud.services;

import com.jarbas.ProductCrud.entities.Product;
import com.jarbas.ProductCrud.exceptions.NotFoundException;
import com.jarbas.ProductCrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product findProductById(UUID id){
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Product updateProduct(Product updatedProduct, UUID id){
        return productRepository.findById(id)
                .map( product -> {
                    product.setName(updatedProduct.getName());
                    product.setDescription(updatedProduct.getDescription());
                    product.setPrice(updatedProduct.getPrice());
                    return productRepository.save(product);
                }).orElseGet(() -> productRepository.save(updatedProduct));
    }

    public void deleteProduct(UUID id){
        productRepository.deleteById(id);
    }

}
