package io.github.acidtango.products.adapter.db;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.github.acidtango.products.adapter.db.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}