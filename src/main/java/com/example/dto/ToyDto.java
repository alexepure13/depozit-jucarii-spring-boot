package com.example.dto;

import lombok.*;

import javax.persistence.Column;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ToyDto {

    private int id;
    private String name;
    private String manufacturer;
    private String age;
    public double price;
    public int quantity;
    private CategoryDto category;

}
