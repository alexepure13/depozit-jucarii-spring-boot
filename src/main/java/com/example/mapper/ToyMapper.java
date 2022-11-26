package com.example.mapper;

import com.example.dto.CategoryDto;
import com.example.dto.ToyDto;
import com.example.model.Toy;
import org.springframework.stereotype.Component;

@Component
public class ToyMapper {


    public ToyDto mapToyDto(Toy toy){
        CategoryDto categoryDto = CategoryDto.builder()
                .id(toy.getCategory().getId())
                .typeOfToy(toy.getCategory().getTypeOfToy())
                .quantity(toy.getCategory().getQuantity())
                .build();

        return ToyDto.builder()
                .id(toy.getId())
                .name(toy.getName())
                .age(toy.getAge())
                .price(toy.getPrice())
                .quantity(toy.getQuantity())
                .manufacturer(toy.getManufacturer())
                .category(categoryDto)
                .build();
    }

    public Toy mapToy(ToyDto toyDto){

        CategoryMapper categoryMapper = new CategoryMapper();

       return Toy.builder()
               .id(toyDto.getId())
               .name(toyDto.getName())
               .age(toyDto.getAge())
               .price(toyDto.getPrice())
               .quantity(toyDto.getQuantity())
               .manufacturer(toyDto.getManufacturer())
               .category(categoryMapper.mapCategory(toyDto.getCategory()))
               .build();
    }
}
