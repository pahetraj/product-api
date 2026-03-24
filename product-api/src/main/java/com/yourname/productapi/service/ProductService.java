package com.yourname.productapi.service;

import com.yourname.productapi.dto.ProductRequest;
import com.yourname.productapi.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest request);
    ProductResponse getProductById(Long id);
    List<ProductResponse> getAllProducts();
    ProductResponse updateProduct(Long id, ProductRequest request);
    void deleteProduct(Long id);
}
