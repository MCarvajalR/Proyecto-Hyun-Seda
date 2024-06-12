package es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.mapper;

import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Category;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.data.request.CategoryCreateRequest;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.data.response.CategoryCreateResponse;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.data.response.CategoryQueryResponse;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryRestMapper {

    Category toCategory(CategoryCreateRequest categoryCreateRequest);

    CategoryCreateResponse toCategoryCreateResponse(Category category);

    CategoryQueryResponse toCategoryQueryResponse(Category category);

}
