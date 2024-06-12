package es.clubpenguin.sample.hexagonalarchitecture.domain.service;

import es.clubpenguin.sample.hexagonalarchitecture.application.ports.input.*;
import es.clubpenguin.sample.hexagonalarchitecture.application.ports.output.ProductEventPublisher;
import es.clubpenguin.sample.hexagonalarchitecture.application.ports.output.ProductOutputPort;
import es.clubpenguin.sample.hexagonalarchitecture.domain.event.ProductCreatedEvent;
import es.clubpenguin.sample.hexagonalarchitecture.domain.exception.ProductNotFound;
import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Product;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ProductService implements CreateProductUseCase, GetProductUseCase, GetAllProductUseCase, GetProductsByCategoryUseCase, EditProductUseCase {

    private final ProductOutputPort productOutputPort;

    private final ProductEventPublisher productEventPublisher;

    @Override
    public Product createProduct(Product product) {
        product = productOutputPort.saveProduct(product);
        productEventPublisher.publishProductCreatedEvent(new ProductCreatedEvent(product.getId()));
        return product;
    }

    @Override
    public Product getProductById(Long id) {
        return productOutputPort.getProductById(id).orElseThrow(() -> new ProductNotFound("Product not found with id " + id));
    }

    @Override
    public List<Product> getAllProducts() {
        return productOutputPort.getAllProducts();
    }

    @Override
    public List<Product> findByCategory(Long categoryId) {
        return productOutputPort.findByCategory(categoryId);
    }


    @Override
    public Product EditProduct(Long id, Product product) {
        return productOutputPort.EditProduct(id,product);
    }
}
