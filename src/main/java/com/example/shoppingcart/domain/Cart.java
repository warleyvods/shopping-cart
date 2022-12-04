package com.example.shoppingcart.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

}
