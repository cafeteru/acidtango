package io.github.acidtango.products.adapter.db;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.acidtango.products.adapter.db.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}