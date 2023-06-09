package io.github.acidtango.products.adapter.api;

import java.util.List;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.acidtango.products.domain.model.ProductDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/products")
public interface ProductAdapter {

    @Operation(summary = "REST endpoint for querying all products")
    @ApiResponse(responseCode = "200", description = "All products",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class)))
    @ApiResponse(responseCode = "204", description = "No results")
    @GetMapping
    ResponseEntity<List<ProductDto>> findAll(@ParameterObject final Pageable pageable);
}
