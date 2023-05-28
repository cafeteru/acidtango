package io.github.acidtango.products.adapter.db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    private int quantityS;
    private int quantityM;
    private int quantityL;
}
