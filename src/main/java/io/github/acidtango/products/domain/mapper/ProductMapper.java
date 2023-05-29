package io.github.acidtango.products.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import io.github.acidtango.common.mappers.DtoEntityMapper;
import io.github.acidtango.products.adapter.db.model.Product;
import io.github.acidtango.products.domain.model.ProductDto;

@Mapper(componentModel = "spring")
public interface ProductMapper extends DtoEntityMapper<ProductDto, Product> {
    @Mapping(source = "stock.quantityS", target = "stock.s")
    @Mapping(source = "stock.quantityM", target = "stock.m")
    @Mapping(source = "stock.quantityL", target = "stock.l")
    @Mapping(target = "totalUnits", expression =
        "java(entity.getStock() != null ? " +
            "entity.getStock().getQuantityS() + entity.getStock().getQuantityM() + " +
            "entity.getStock().getQuantityL() : 0)")
    @Override
    ProductDto toDto(final Product entity);
}
