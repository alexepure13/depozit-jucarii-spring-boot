package com.example.model;

import com.example.dto.ToyDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "t_categories")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipjucarii")
    private String typeOfToy;

    @Column(name="cantitate")
    private int quantity;

    @OneToMany(targetEntity = Toy.class, mappedBy = "category",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    List<Toy> toyList;

}
