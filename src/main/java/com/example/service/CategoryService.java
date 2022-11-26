package com.example.service;

import com.example.dto.CategoryDto;
import com.example.mapper.CategoryMapper;
import com.example.model.Category;
import com.example.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    public List<CategoryDto> getCategoriesList(){
        return categoryRepository.findAll().stream()
                .map(e -> categoryMapper.mapCategoryDto(e))
                .collect(Collectors.toList());
    }

    public CategoryDto getCategoryById(int id) {
        Category category = categoryRepository.findById(id).get();
        return categoryMapper.mapCategoryDto(category);
    }

    public void saveCategory(CategoryDto categoryDto){
        Category category = categoryMapper.mapCategory(categoryDto);
        categoryRepository.save(category);
    }

    public void deleteCategoryById(int id){
        categoryRepository.deleteById(id);
    }

}
