package io.github.acidtango.products.adapter.api.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import io.github.acidtango.products.adapter.api.ProductAdapter;
import io.github.acidtango.products.domain.model.ProductDto;
import io.github.acidtango.products.port.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController implements ProductAdapter {
    private final ProductService productService;

    @Override
    public ResponseEntity<List<ProductDto>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }
}
