package io.github.acidtango.products.port;

import java.util.List;

import io.github.acidtango.products.adapter.db.model.Product;

public interface ProductService {
    List<Product> findAll();
}
