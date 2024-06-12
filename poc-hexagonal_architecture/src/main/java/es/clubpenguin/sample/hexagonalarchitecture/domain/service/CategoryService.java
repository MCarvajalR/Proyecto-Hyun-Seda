package es.clubpenguin.sample.hexagonalarchitecture.domain.service;

import es.clubpenguin.sample.hexagonalarchitecture.application.ports.input.CreateCategoryUseCase;
import es.clubpenguin.sample.hexagonalarchitecture.application.ports.input.GetAllCategoryUseCase;
import es.clubpenguin.sample.hexagonalarchitecture.application.ports.input.GetCategoryUseCase;
import es.clubpenguin.sample.hexagonalarchitecture.application.ports.output.CategoryEventPublisher;
import es.clubpenguin.sample.hexagonalarchitecture.application.ports.output.CategoryOutputPort;
import es.clubpenguin.sample.hexagonalarchitecture.domain.event.CategoryCreatedEvent;
import es.clubpenguin.sample.hexagonalarchitecture.domain.exception.CategoryNotFound;
import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Category;
import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Product;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CategoryService implements CreateCategoryUseCase, GetCategoryUseCase, GetAllCategoryUseCase {

    private final CategoryOutputPort categoryOutputPort;

    private final CategoryEventPublisher categoryEventPublisher;

    @Override
    public Category createCategory(Category category) {
        category = categoryOutputPort.saveCategory(category);
        categoryEventPublisher.publishCategoryCreatedEvent(new CategoryCreatedEvent(category.getId_category()));
        return category;
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryOutputPort.getCategoryById(id).orElseThrow(() -> new CategoryNotFound("Category not found with id " + id));
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryOutputPort.getAllCategories();
    }
}
