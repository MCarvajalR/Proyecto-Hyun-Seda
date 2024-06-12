package es.clubpenguin.sample.hexagonalarchitecture.application.ports.output;

import es.clubpenguin.sample.hexagonalarchitecture.domain.event.CategoryCreatedEvent;

public interface CategoryEventPublisher {

    void publishCategoryCreatedEvent(CategoryCreatedEvent event);

}
