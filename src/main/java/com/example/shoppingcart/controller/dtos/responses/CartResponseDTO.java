package com.example.shoppingcart.controller.dtos.responses;

import java.util.ArrayList;
import java.util.List;

public record CartResponseDTO(
        Long id,
        String name,
        List<ProductResponseDTO> products
) {
}
