package io.github.acidtango.products.adapter.db;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.acidtango.products.adapter.db.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
    @Aggregation(pipeline = {
        "{$project: {" +
            "name: 1," +
            "salesUnit: 1," +
            "stock: 1," +
            "totalUnits: {$sum: ['$salesUnit', '$stock.quantityS', '$stock.quantityM', '$stock.quantityL']}}}",
        "{$sort: {totalUnits: -1}}"
    })
    List<Product> findAllOrderByTotalUnitsAsc();
}