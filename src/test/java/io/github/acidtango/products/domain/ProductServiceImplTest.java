package io.github.acidtango.products.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import io.github.acidtango.products.adapter.db.ProductRepository;
import io.github.acidtango.products.adapter.db.model.Product;
import io.github.acidtango.products.adapter.db.model.Stock;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    private Pageable pageable;
    private List<Product> products;

    @InjectMocks
    private ProductServiceImpl service;

    @Mock
    private ProductRepository repository;

    @BeforeEach
    void setUp() {
        pageable = PageRequest.of(0, 10);
        products = List.of(
            createProduct("V-NECH BASIC SHIRT", 100, createStock(4, 9, 0)),
            createProduct("CONTRASTING FABRIC T-SHIRT", 50, createStock(35, 5, 9))
        );
    }

    @Test
    void findAllCustom_with_successfully_response() {
        when(repository.findAllCustom(any())).thenReturn(products);
        var result = service.findAll(pageable);
        assertNotEquals(products.getClass(), result.getClass());
        assertFalse(result.isEmpty());
        assertEquals(products.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            assertEquals(products.get(i).getName(), result.get(i).getName());
            assertEquals(products.get(i).getSalesUnit(), result.get(i).getSalesUnit());
            assertEquals(products.get(i).getStock().getQuantityS(), result.get(i).getStock().getS());
            assertEquals(products.get(i).getStock().getQuantityM(), result.get(i).getStock().getM());
            assertEquals(products.get(i).getStock().getQuantityL(), result.get(i).getStock().getL());
        }
    }

    @Test
    void findAllCustom_with_empty_response() {
        when(repository.findAllCustom(any())).thenReturn(Collections.emptyList());
        var result = service.findAll(pageable);
        assertNotEquals(products.getClass(), result.getClass());
        assertTrue(result.isEmpty());
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