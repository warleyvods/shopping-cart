package com.example.shoppingcart.controller.mappers;

import com.example.shoppingcart.controller.dtos.requests.CartRequestDTO;
import com.example.shoppingcart.controller.dtos.responses.CartResponseDTO;
import com.example.shoppingcart.domain.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CartMapper {

    Cart toDomain(CartRequestDTO cartRequestDTO);

    CartResponseDTO fromDomain(Cart cart);

}
