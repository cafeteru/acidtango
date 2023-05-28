package io.github.acidtango.products.adapter.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.acidtango.products.adapter.db.model.Product;

@RequestMapping(value = "/products")
public interface ProductAdapter {
    @GetMapping("")
    ResponseEntity<List<Product>> findAll();
}
