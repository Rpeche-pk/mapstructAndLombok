package com.lpa.app.test;

import com.lpa.app.dto.GetProduct;
import com.lpa.app.entity.Product;
import com.lpa.app.mapper.ProductMapper;
import com.lpa.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class InitDataBase {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @Bean
    public CommandLineRunner testProductMapper(){
        return args -> {
            List<Product> products= productRepository.findAll();
            System.out.println("PRODUCTOS");
            products.forEach(System.out::println);

            System.out.println("GETPRODUCTOS");
            List<GetProduct> getProductList= productMapper.toGetProductList(products);
            getProductList.forEach(System.out::println);


            System.out.println("MAPPED");
            List<Product> mappedProducts= productMapper.toEntityList(getProductList);
            mappedProducts.forEach(System.out::println);
        };
    }
}
