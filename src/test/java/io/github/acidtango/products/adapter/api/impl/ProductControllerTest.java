package io.github.acidtango.products.adapter.api.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import org.springframework.http.HttpStatus;

import io.github.acidtango.products.domain.model.ProductDto;
import io.github.acidtango.products.domain.model.StockDto;
import io.github.acidtango.products.port.ProductService;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
    private Pageable pageable;
    private List<ProductDto> products;
    @InjectMocks
    private ProductController productController;
    @Mock
    private ProductService productService;

    @BeforeEach
    void setUp() {
        pageable = PageRequest.of(0, 10);
        products = List.of(
            createProductDto("V-NECH BASIC SHIRT", 100, createStockDto(4, 9, 0)),
            createProductDto("CONTRASTING FABRIC T-SHIRT", 50, createStockDto(35, 5, 9))
        );
    }

    @Test
    void findAll() {
        when(productService.findAll(any())).thenReturn(products);
        var result = productController.findAll(pageable);
        assertNotNull(result);
        assertNotNull(HttpStatus.ACCEPTED, String.valueOf(result.getStatusCode()));
        assertNotNull(result.getBody());
        assertEquals(products.getClass(), result.getBody().getClass());
        assertFalse(result.getBody().isEmpty());
        assertEquals(products.size(), result.getBody().size());
        assertEquals(products.get(0).getName(), result.getBody().get(0).getName());
    }

    @Test
    void findAllWithEmptyList() {
        when(productService.findAll(any())).thenReturn(Collections.emptyList());
        var result = productController.findAll(pageable);
        assertNotNull(result);
        assertNotNull(HttpStatus.NO_CONTENT, String.valueOf(result.getStatusCode()));
        assertNull(result.getBody());
    }

    private ProductDto createProductDto(String name, int salesUnit, StockDto stock) {
        return ProductDto.builder()
            .name(name)
            .salesUnit(salesUnit)
            .stock(stock)
            .build();
    }

    private StockDto createStockDto(int quantityS, int quantityM, int quantityL) {
        return StockDto.builder()
            .s(quantityS)
            .m(quantityM)
            .l(quantityL)
            .build();
    }
}