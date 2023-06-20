package com.lpa.app.mapper;

import com.lpa.app.dto.GetProduct;
import com.lpa.app.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CategoryMapper.class})
public interface ProductMapper {


    @Mapping(source = "creationDate", target = "creationDate", dateFormat = "yyyy-MM-dd HH-mm-ss")
    @Mapping(source = "name" , target = "productName")
    @Mapping(source = "id" , target = "productId")
    @Mapping(source = "category" , target = "category")
    @Mapping(source = "price" , target = "price", numberFormat = "$#.00")
    GetProduct toGetDto(Product product);

    @InheritInverseConfiguration
    Product toEntity(GetProduct getProduct);

    List<GetProduct> toGetProductList(List<Product> productList);
    List<Product> toEntityList(List<GetProduct> getProductList);
}
