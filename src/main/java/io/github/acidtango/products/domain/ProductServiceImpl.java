package io.github.acidtango.products.domain;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.acidtango.products.adapter.db.ProductRepository;
import io.github.acidtango.products.adapter.db.model.Product;
import io.github.acidtango.products.port.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
