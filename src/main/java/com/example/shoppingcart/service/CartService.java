package com.example.shoppingcart.service;

import com.example.shoppingcart.domain.Cart;
import com.example.shoppingcart.domain.Product;
import com.example.shoppingcart.repository.CartRepository;
import com.example.shoppingcart.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public Cart save(final Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart findById(final Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    public List<Cart> all() {
        return cartRepository.findAll();
    }


}
