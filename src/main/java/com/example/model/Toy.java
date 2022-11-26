package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.collection.internal.AbstractPersistentCollection;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "t_toys")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Toy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name="nume")
    private String name;
    @Column (name="producator")
    private String manufacturer;
    @Column (name="varsta")
    private String age;
    @Column (name="pret")
    public double price;
    @Column (name="cantitate")
    public int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category = new Category();


}
