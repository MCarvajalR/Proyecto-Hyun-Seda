package es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.mapper;

import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.data.request.ProductCreateRequest;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.data.response.ProductCreateResponse;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.data.response.ProductQueryResponse;
import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductRestMapper {

    Product toProduct(ProductCreateRequest productCreateRequest);

    ProductCreateResponse toProductCreateResponse(Product product);

    ProductQueryResponse toProductQueryResponse(Product product);

}
