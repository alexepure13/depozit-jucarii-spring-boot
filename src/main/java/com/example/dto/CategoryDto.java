package com.example.dto;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CategoryDto {

    private int id;
    private String typeOfToy;
    public int quantity;

}
