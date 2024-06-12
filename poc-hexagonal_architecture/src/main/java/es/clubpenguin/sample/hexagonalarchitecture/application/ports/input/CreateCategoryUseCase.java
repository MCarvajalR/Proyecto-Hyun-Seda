package es.clubpenguin.sample.hexagonalarchitecture.application.ports.input;

import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Category;

public interface CreateCategoryUseCase {

    Category createCategory(Category category);

}
