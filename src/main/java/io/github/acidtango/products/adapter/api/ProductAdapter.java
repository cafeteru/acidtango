package io.github.acidtango.products.adapter.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.acidtango.products.domain.model.ProductDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping(value = "/products")
public interface ProductAdapter {

    @Operation(summary = "REST endpoint for querying")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "All products")
    })
    @GetMapping("")
    ResponseEntity<List<ProductDto>> findAllOrdered();
}
