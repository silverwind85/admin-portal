package com.adminportal.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ShippingAddressName;
    private String ShippingAddressStreet1;
    private String ShippingAddressStreet2;
    private String ShippingAddressCity;
    private String ShippingAddressState;
    private String ShippingAddressCountry;
    private String ShippingAddressZipcode;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
