package com.example.shoppingcart.controller;

import com.example.shoppingcart.controller.dtos.requests.ProductRequestDTO;
import com.example.shoppingcart.controller.dtos.responses.ProductResponseDTO;
import com.example.shoppingcart.controller.mappers.ProductMapper;
import com.example.shoppingcart.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping("/save")
    public ProductResponseDTO product(@RequestBody final ProductRequestDTO productRequestDTO) {
        return productMapper.fromDomain(productService.save(productMapper.toDomain(productRequestDTO)));
    }

    @PostMapping("/remove-product")
    public void product(@RequestParam final Long cartId, @RequestParam final Long productId, @RequestParam final Integer quantity) {
         productService.remove(cartId, productId, quantity);
    }
}
