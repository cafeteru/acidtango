package io.github.acidtango.common.util;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import io.github.acidtango.products.adapter.db.ProductRepository;
import io.github.acidtango.products.adapter.db.model.Product;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InitProject {
    private final ProductRepository productRepository;

    @PostConstruct
    public void init() {
        productRepository.deleteAll();
        var product = Product.builder().name("Product 1").salesUnit(1).build();
        productRepository.save(product);
    }
}
