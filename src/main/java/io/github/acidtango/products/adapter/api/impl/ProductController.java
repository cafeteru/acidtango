package io.github.acidtango.products.adapter.api.impl;

import java.util.List;

import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<List<ProductDto>> findAll(final Pageable pageable) {
        final var list = productService.findAll(pageable);
        return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
    }
}
