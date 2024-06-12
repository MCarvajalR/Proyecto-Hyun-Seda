package es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.mapper;

import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Category;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryPersistenceMapper {

    CategoryEntity toCategoryEntity(Category category);

    Category toCategory(CategoryEntity categoryEntity);

}
