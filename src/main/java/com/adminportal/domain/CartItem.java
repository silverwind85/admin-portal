package com.adminportal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int qty;
    private BigDecimal subtotal;

    @OneToOne(cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Product product;

    @OneToMany(mappedBy = "cartItem")
    @JsonIgnore
    private List<ProductToCartItem> productToCartItems;

    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;

}
