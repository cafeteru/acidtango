package io.github.acidtango.products.adapter.api.impl;

import java.util.List;

import org.springframework.data.domain.Page;
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
        var a = pageable.getSort();
        final var page = productService.findAll(pageable);
        return ResponseEntity.ok(page);
    }
}
