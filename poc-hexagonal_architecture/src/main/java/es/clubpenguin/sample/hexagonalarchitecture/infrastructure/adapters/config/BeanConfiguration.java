package es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.config;

import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.ProductPersistenceAdapter;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.mapper.ProductPersistenceMapper;
import es.clubpenguin.sample.hexagonalarchitecture.domain.service.ProductService;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.eventpublisher.ProductEventPublisherAdapter;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.repository.ProductRepository;

import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.CategoryPersistenceAdapter;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.mapper.CategoryPersistenceMapper;
import es.clubpenguin.sample.hexagonalarchitecture.domain.service.CategoryService;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.eventpublisher.CategoryEventPublisherAdapter;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.repository.CategoryRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductPersistenceAdapter productPersistenceAdapter(ProductRepository productRepository, ProductPersistenceMapper productPersistenceMapper) {
        return new ProductPersistenceAdapter(productRepository, productPersistenceMapper);
    }

    @Bean
    public ProductEventPublisherAdapter productEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        return new ProductEventPublisherAdapter(applicationEventPublisher);
    }

    @Bean
    public ProductService productService(ProductPersistenceAdapter productPersistenceAdapter, ProductEventPublisherAdapter productEventPublisherAdapter) {
        return new ProductService(productPersistenceAdapter, productEventPublisherAdapter);
    }



    @Bean
    public CategoryPersistenceAdapter categoryPersistenceAdapter(CategoryRepository categoryRepository, CategoryPersistenceMapper categoryPersistenceMapper) {
        return new CategoryPersistenceAdapter(categoryRepository, categoryPersistenceMapper);
    }

    @Bean
    public CategoryEventPublisherAdapter categoryEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        return new CategoryEventPublisherAdapter(applicationEventPublisher);
    }

    @Bean
    public CategoryService categoryService(CategoryPersistenceAdapter categoryPersistenceAdapter, CategoryEventPublisherAdapter categoryEventPublisherAdapter) {
        return new CategoryService(categoryPersistenceAdapter, categoryEventPublisherAdapter);
    }


}
