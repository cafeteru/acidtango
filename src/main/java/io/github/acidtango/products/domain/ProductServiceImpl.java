package io.github.acidtango.products.domain;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import io.github.acidtango.products.adapter.db.ProductRepositoryCustom;
import io.github.acidtango.products.domain.mapper.ProductMapper;
import io.github.acidtango.products.domain.model.ProductDto;
import io.github.acidtango.products.port.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepositoryCustom productRepositoryCustom;
    private final ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Override
    public List<ProductDto> findAllOrdered() {
        final var result = productRepositoryCustom.findAllOrdered();
        return mapper.toDtos(result);
    }
}
