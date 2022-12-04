package com.example.shoppingcart.repository;

import com.example.shoppingcart.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
