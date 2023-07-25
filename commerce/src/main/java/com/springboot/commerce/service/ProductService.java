package com.springboot.commerce.service;



import com.springboot.commerce.data.dto.ProductDto;
import com.springboot.commerce.data.dto.ProductResponseDto;
import com.springboot.commerce.data.entity.Product;

import java.util.List;

public interface ProductService {

    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;


    List<ProductResponseDto> searchProductsByName(String keyword);

}