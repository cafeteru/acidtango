package io.github.acidtango.products.adapter.db;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.github.acidtango.products.adapter.db.model.Product;
import io.github.acidtango.products.adapter.db.model.Stock;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class ProductRepositoryTest {
    private List<Product> products;
    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void init() {
        productRepository.deleteAll();
        products = List.of(
            createProduct("V-NECH BASIC SHIRT", 100, createStock(4, 9, 0)),
            createProduct("CONTRASTING FABRIC T-SHIRT", 50, createStock(35, 9, 9)),
            createProduct("RAISED PRINT T-SHIRT", 80, createStock(20, 2, 20)),
            createProduct("PLEATED T-SHIRT 3", 25, createStock(25, 30, 10)),
            createProduct("CONTRASTING LACE T-SHIRT", 650, createStock(0, 1, 0)),
            createProduct("SLOGAN T-SHIRT", 20, createStock(9, 2, 5))
        );
        productRepository.saveAll(products);
    }

    @Test
    void findAllWithoutSorts() {
        var results = productRepository.findAllCustom(Pageable.unpaged());
        assertFalse(results.isEmpty());
        assertEquals(products.size(), results.size());
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "name,asc",
        "salesUnit,desc"
    })
    void findAllCustomWithSorts(String sort) {
        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(sort));
        var results = productRepository.findAllCustom(pageable);
        assertFalse(results.isEmpty());
        assertEquals(products.size(), results.size());
    }

    private Product createProduct(String name, int salesUnit, Stock stock) {
        return Product.builder()
            .name(name)
            .salesUnit(salesUnit)
            .stock(stock)
            .build();
    }

    private Stock createStock(int quantityS, int quantityM, int quantityL) {
        return Stock.builder()
            .quantityS(quantityS)
            .quantityM(quantityM)
            .quantityL(quantityL)
            .build();
    }
}