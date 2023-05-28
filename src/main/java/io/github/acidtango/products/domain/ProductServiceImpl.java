package io.github.acidtango.products.domain;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import io.github.acidtango.products.adapter.db.ProductRepository;
import io.github.acidtango.products.domain.mapper.ProductMapper;
import io.github.acidtango.products.domain.model.ProductDto;
import io.github.acidtango.products.port.ProductService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Override
    public List<ProductDto> findAll() {
        final var result = productRepository.findAll();
        return mapper.toDtos(result);
    }
}
