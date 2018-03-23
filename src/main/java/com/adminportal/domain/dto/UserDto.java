package com.adminportal.domain.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Transient;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    @Size(min=3,max=30,message = "{userDto.name.size}")
    private String username;
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private boolean enabled;
    private String password;
    @Transient
    @Size(min=3,max=30,message = "{userDto.newPassword.size}")
    private String newPassword;
    @Transient
    private String confirmPassword;
    private String address;
    private String confirmationToken;
    private List<ShoppingCartDto> shoppingCartDtos = new ArrayList<>();
    private List<UserShippingDto> userShippingDtos=new ArrayList<>();
    private List<UserPaymentDto> userPaymentDtos = new ArrayList<>();
    private Set<UserRoleDto> userRoleDtos = new HashSet<>();
}
