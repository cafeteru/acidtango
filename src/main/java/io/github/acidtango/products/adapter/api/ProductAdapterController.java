package io.github.acidtango.products.adapter.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import io.github.acidtango.products.adapter.db.model.Product;
import io.github.acidtango.products.port.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductAdapterController implements ProductAdapter {
    private final ProductService productService;

    @Override
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }
}
