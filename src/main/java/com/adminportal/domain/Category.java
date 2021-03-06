package com.adminportal.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Long id;
    @NotNull
    @Size(min=3,max=30, message = "{category.name.size}")
    private String name;
    @Size(min=3,max=255, message = "{category.description.size}")
    private String description;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(name = "join_category_product", joinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "category_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")})
    private List<Product> products=new ArrayList<>();
    @Transient
    private MultipartFile image;

    public Category(String name){
        this.name = name;

    }


}
