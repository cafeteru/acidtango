package io.github.acidtango.products.adapter.db;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Repository;

import io.github.acidtango.products.adapter.db.model.Product;
import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class ProductRepositoryCustom {
    private final MongoTemplate mongoTemplate;

    public List<Product> findAllOrdered() {
        final String expression = "salesUnit + stock.quantityS + stock.quantityM + stock.quantityL";
        final var project = Aggregation.project("name", "salesUnit", "stock")
            .andExpression(expression).as("totalUnits");
        final var sort = Aggregation.sort(Sort.Direction.DESC, "totalUnits");
        final var aggregation = Aggregation.newAggregation(project, sort);
        return mongoTemplate.aggregate(aggregation, mongoTemplate.getCollectionName(Product.class), Product.class)
            .getMappedResults();
    }

}
