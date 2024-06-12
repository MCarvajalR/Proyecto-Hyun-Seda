package es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence;

import es.clubpenguin.sample.hexagonalarchitecture.application.ports.output.CategoryOutputPort;
import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Category;
import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Product;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.entity.CategoryEntity;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.entity.ProductEntity;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.mapper.CategoryPersistenceMapper;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryOutputPort {

    private final CategoryRepository categoryRepository;

    private final CategoryPersistenceMapper categoryPersistenceMapper;

    @Override
    public Category saveCategory(Category category) {
        CategoryEntity categoryEntity = categoryPersistenceMapper.toCategoryEntity(category);
        categoryEntity = categoryRepository.save(categoryEntity);
        return categoryPersistenceMapper.toCategory(categoryEntity);
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        Optional<CategoryEntity> categoryEntity = categoryRepository.findById(id);

        if(categoryEntity.isEmpty()) {
            return Optional.empty();
        }

        Category category = categoryPersistenceMapper.toCategory(categoryEntity.get());
        return Optional.of(category);
    }

    @Override
    public List<Category> getAllCategories() {
        List<CategoryEntity> allCategories = categoryRepository.findAll();

        List<Category> categoryFinal = pasaraCategories(allCategories);
        return categoryFinal;
    }

    public List<Category> pasaraCategories(List<CategoryEntity> allCategories) {
        List<Category> categories = new ArrayList<>();
        for(CategoryEntity i:allCategories){
            categories.add(categoryPersistenceMapper.toCategory(i));
        }
        return categories;
    }

}
