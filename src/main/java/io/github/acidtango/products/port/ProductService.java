package io.github.acidtango.products.port;

import java.util.List;

import org.springframework.data.domain.Pageable;

import io.github.acidtango.products.domain.model.ProductDto;

public interface ProductService {
    List<ProductDto> findAll(Pageable pageable);
}
