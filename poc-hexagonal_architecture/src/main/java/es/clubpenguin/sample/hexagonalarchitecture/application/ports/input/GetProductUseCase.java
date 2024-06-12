package es.clubpenguin.sample.hexagonalarchitecture.application.ports.input;

import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Product;

public interface GetProductUseCase {

    Product getProductById(Long id);

}
