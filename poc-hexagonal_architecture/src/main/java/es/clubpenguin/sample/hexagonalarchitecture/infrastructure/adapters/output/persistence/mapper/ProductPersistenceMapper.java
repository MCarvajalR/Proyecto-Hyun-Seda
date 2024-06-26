package es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.mapper;

import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Product;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductPersistenceMapper {

    ProductEntity toProductEntity(Product product);

    Product toProduct(ProductEntity productEntity);

}
