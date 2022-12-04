package com.example.shoppingcart.controller.mappers;

import com.example.shoppingcart.controller.dtos.requests.ProductRequestDTO;
import com.example.shoppingcart.controller.dtos.responses.ProductResponseDTO;
import com.example.shoppingcart.domain.Product;
import com.example.shoppingcart.service.CartService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CartService.class)
public interface ProductMapper {

    @Mapping(target = "cart", source = "cartId")
    Product toDomain(ProductRequestDTO productRequestDTO);

    ProductResponseDTO fromDomain(Product product);

}
