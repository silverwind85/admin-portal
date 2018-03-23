package com.adminportal.domain.dto;


import com.adminportal.domain.UserBilling;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserPaymentDto {

    private Long id;
    private String type;
    private String cardName;
    private String cardNumber;
    private int expiryMonth;
    private int expiryYear;
    private int cvc;
    private String holderName;
    private boolean defaultPayment;
    private User user;
    private UserBilling userBilling;
}
