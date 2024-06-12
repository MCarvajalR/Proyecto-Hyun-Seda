package es.clubpenguin.sample.hexagonalarchitecture.application.ports.output;

import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Category;
import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface CategoryOutputPort {

    Category saveCategory(Category category);

    Optional<Category> getCategoryById(Long id);

    List<Category> getAllCategories();

}
