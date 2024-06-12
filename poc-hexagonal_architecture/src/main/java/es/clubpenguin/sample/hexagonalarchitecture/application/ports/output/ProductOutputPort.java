package es.clubpenguin.sample.hexagonalarchitecture.application.ports.output;

import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductOutputPort {

    Product saveProduct(Product product);

    Optional<Product> getProductById(Long id);

    List<Product> getAllProducts();

    List<Product> findByCategory(Long categoryId);

    Product EditProduct(Long id, Product product);

}
