package com.adminportal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal GrandTotal;
    @OneToMany(mappedBy = "shoppingCart",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CartItem> cartItems;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;




}
