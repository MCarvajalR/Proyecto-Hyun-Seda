package es.clubpenguin.sample.hexagonalarchitecture.domain.exception;

public class ProductNotFound extends RuntimeException {

    public ProductNotFound(String message) {
        super(message);
    }

}
