package com.example.mapper;

import com.example.dto.CategoryDto;
import com.example.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryDto mapCategoryDto(Category category){
        return CategoryDto.builder()
                .id(category.getId())
                .typeOfToy(category.getTypeOfToy())
                .quantity(category.getQuantity())
                .build();
    }

    public Category mapCategory(CategoryDto categoryDto){
        return Category.builder()
                .id(categoryDto.getId())
                .typeOfToy(categoryDto.getTypeOfToy())
                .quantity(categoryDto.getQuantity())
                .build();
    }
}
