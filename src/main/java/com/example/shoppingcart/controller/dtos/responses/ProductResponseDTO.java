package com.example.shoppingcart.controller.dtos.responses;

public record ProductResponseDTO(
        Long id,
        String name,
        Integer quantity
) {
}
