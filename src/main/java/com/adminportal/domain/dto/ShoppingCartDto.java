package com.adminportal.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShoppingCartDto {
    private Long id;
    private Integer quantity;
    private LocalDateTime addDate = LocalDateTime.now();
    private Long productId;
    private UserDto userDto;
}
