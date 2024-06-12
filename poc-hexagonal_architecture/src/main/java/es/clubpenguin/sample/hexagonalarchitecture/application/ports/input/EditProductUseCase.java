package es.clubpenguin.sample.hexagonalarchitecture.application.ports.input;

import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Category;
import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Product;

public interface EditProductUseCase {
    Product EditProduct(Long id,Product product);
}

