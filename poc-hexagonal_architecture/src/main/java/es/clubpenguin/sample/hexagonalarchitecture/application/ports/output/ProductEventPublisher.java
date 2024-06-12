package es.clubpenguin.sample.hexagonalarchitecture.application.ports.output;

import es.clubpenguin.sample.hexagonalarchitecture.domain.event.ProductCreatedEvent;

public interface ProductEventPublisher {

    void publishProductCreatedEvent(ProductCreatedEvent event);

}
