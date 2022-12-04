package com.example.shoppingcart.service;

import com.example.shoppingcart.domain.Cart;
import com.example.shoppingcart.domain.Product;
import com.example.shoppingcart.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CartService cartService;

    public Product save(final Product product) {
        final Optional<Product> productFinded = productRepository.findByName(product.getName());

        if (productFinded.isPresent() && productFinded.get().getName().equals(product.getName())) {
            final Integer quantity = Optional.ofNullable(productFinded.get().getQuantity()).orElse(1);
            productFinded.get().setQuantity(quantity + 1);
            return productRepository.save(productFinded.get());
        }

        return productRepository.save(product);
    }

    public Product findById(final Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void remove(Long cartId, Long productId, Integer quantity) {
        final Cart cart = cartService.findById(cartId);
        if (cart == null) {
            throw new NullPointerException("parou!");
        }

        final Product product = findById(productId);

        if (product.getQuantity() - quantity == 0) {
            productRepository.delete(product);
        } else {
            int rest = product.getQuantity() - quantity;
            product.setQuantity(rest);
            productRepository.save(product);
        }
    }
}
