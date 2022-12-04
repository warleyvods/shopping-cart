package com.example.shoppingcart.controller;

import com.example.shoppingcart.controller.dtos.requests.CartRequestDTO;
import com.example.shoppingcart.controller.dtos.responses.CartResponseDTO;
import com.example.shoppingcart.controller.mappers.CartMapper;
import com.example.shoppingcart.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {

    private final CartService cartService;
    private final CartMapper cartMapper;

    @PostMapping("/save")
    public CartResponseDTO cart(@RequestBody final CartRequestDTO cartRequestDTO) {
        return cartMapper.fromDomain(cartService.save(cartMapper.toDomain(cartRequestDTO)));
    }

    @GetMapping("/list")
    public List<CartResponseDTO> list() {
        return cartService.all().stream().map(cartMapper::fromDomain).toList();
    }

}
