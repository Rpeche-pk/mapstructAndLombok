package com.lpa.app.mapper;

import com.lpa.app.dto.GetCategory;
import com.lpa.app.entity.Category;
import com.lpa.app.repository.CategoryRepository;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CategoryMapper {

    @Autowired
    private CategoryRepository categoryRepository;

    @Mapping(source = "id", target = "categoryId")
    @Mapping(source = "name", target = "categoryName")
    abstract GetCategory toGetCategory(Category category);


    Category toEntity(GetCategory getCategory){
        if (getCategory == null) {
            return null;
        }
        Category category= categoryRepository.findById(getCategory.getCategoryId())
                .orElseGet(()-> null);

        if (category == null) {
            return null;
        }

        category.setId(getCategory.getCategoryId());
        category.setName(getCategory.getCategoryName());
        return category;


    }

    abstract List<GetCategory> toGetCategoryList(List<Category> categoryList);
    abstract List<Category> toEntityList(List<GetCategory> getCategoryList);

}
