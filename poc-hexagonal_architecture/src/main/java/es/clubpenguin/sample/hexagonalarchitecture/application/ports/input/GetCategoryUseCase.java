package es.clubpenguin.sample.hexagonalarchitecture.application.ports.input;

import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Category;

public interface GetCategoryUseCase {

    Category getCategoryById(Long id);

}
