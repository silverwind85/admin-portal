package com.adminportal.domain.dto;


import com.adminportal.domain.UserPayment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserBillingDto {


    private Long id;
    private String userBillingName;
    private String userBillingStreet1;
    private String userBillingStreet2;
    private String userBillingCity;
    private String userBillingVoivodeship;
    private String userBillingCountry;
    private String userBillingZipcode;
    private UserPayment userPayment;

}