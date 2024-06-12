package es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.eventpublisher;

import es.clubpenguin.sample.hexagonalarchitecture.application.ports.output.CategoryEventPublisher;
import es.clubpenguin.sample.hexagonalarchitecture.domain.event.CategoryCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class CategoryEventPublisherAdapter implements CategoryEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishCategoryCreatedEvent(CategoryCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

}
