package es.clubpenguin.sample.hexagonalarchitecture.domain.exception;

public class CategoryNotFound extends RuntimeException {

    public CategoryNotFound(String message) {
        super(message);
    }

}
