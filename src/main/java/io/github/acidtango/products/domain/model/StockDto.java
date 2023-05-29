package io.github.acidtango.products.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Product")
public class StockDto {
    @Schema(description = "Size S units", example = "4")
    private int s;
    @Schema(description = "Size M units", example = "9")
    private int m;
    @Schema(description = "Size L units", example = "0")
    private int l;
    @Schema(description = "Total units", example = "10")
    private int totalUnits;
}
