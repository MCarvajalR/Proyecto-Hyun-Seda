package es.clubpenguin.sample.hexagonalarchitecture.application.ports.input;

import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Category;
import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Product;

import java.util.List;

public interface GetAllCategoryUseCase {
    List<Category> getAllCategories();
}
