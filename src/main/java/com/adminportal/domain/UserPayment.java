package com.adminportal.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "UserPayment")
public class UserPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String type;
	private String cardName;
	private String cardNumber;
	private int expiryMonth;
	private int expiryYear;
	private int cvc;
	private String holderName;
	private boolean defaultPayment;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "userPayment")
	private UserBilling userBilling;


}
