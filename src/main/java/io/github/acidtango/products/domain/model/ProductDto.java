package io.github.acidtango.products.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Product")
public class ProductDto {
    @Schema(description = "Name of the product", example = "V-NECH BASIC SHIRT")
    private String name;

    @Schema(description = "Sales unit available", example = "100")
    private int salesUnit;

    @Schema(description = "Stock available")
    private StockDto stock;
}