package io.github.acidtango.common.util;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import io.github.acidtango.products.adapter.db.ProductRepository;
import io.github.acidtango.products.adapter.db.model.Product;
import io.github.acidtango.products.adapter.db.model.Stock;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InitProject {
    private final ProductRepository productRepository;

    @PostConstruct
    public void init() {
        productRepository.deleteAll();
        productRepository.saveAll(
            List.of(
                createProduct("V-NECH BASIC SHIRT", 100, createStock(4, 9, 0)),
                createProduct("CONTRASTING FABRIC T-SHIRT", 50, createStock(35, 9, 9)),
                createProduct("RAISED PRINT T-SHIRT", 80, createStock(20, 2, 20)),
                createProduct("PLEATED T-SHIRT 3", 25, createStock(25, 30, 10)),
                createProduct("CONTRASTING LACE T-SHIRT", 650, createStock(0, 1, 0)),
                createProduct("SLOGAN T-SHIRT", 20, createStock(9, 2, 5))
            )
        );
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
