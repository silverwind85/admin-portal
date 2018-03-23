package com.adminportal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;
    @Size(min=3,max=30,message = "{product.name.size}")
    private String name;

    private BigDecimal price;
    @ManyToMany(cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY,mappedBy ="products" )
    private List<Category> categories=new ArrayList<>();
    private double shippingWeight;
    private boolean isAvailable;
    @Size(min=3,max=2000,message = "{product.description.size}")
    @Column(length = 3000)
    private String description;
    private int quantity;
    private String imagePath;
    @Transient
    private MultipartFile image;
    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "product")
    @JsonIgnore
    private List<ProductToCartItem> productToCartItems;

    public Product(String name,BigDecimal price,List<Category> categories,
                   double shippingWeight,boolean isAvailable,String description,int quantity){
        this.name = name;
        this.price = price;
        this.categories = categories;
        this.shippingWeight = shippingWeight;
        this.isAvailable = isAvailable;
        this.description = description;
        this.quantity = quantity;


    }
    public Product(String name,BigDecimal price,double shippingWeight){
        this.name = name;
        this.price = price;
        this.shippingWeight=shippingWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.shippingWeight, shippingWeight) != 0) return false;
        if (isAvailable != product.isAvailable) return false;
        if (quantity != product.quantity) return false;
        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (categories != null ? !categories.equals(product.categories) : product.categories != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        return image != null ? image.equals(product.image) : product.image == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        temp = Double.doubleToLongBits(shippingWeight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isAvailable ? 1 : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }
}
