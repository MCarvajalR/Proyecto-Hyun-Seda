package es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.eventlistener;

import es.clubpenguin.sample.hexagonalarchitecture.domain.event.CategoryCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CategoryEventListenerAdapter {

    @EventListener
    public void handle(CategoryCreatedEvent event){
        log.info("Category created with id " + event.getId() + " at " + event.getDate());
    }

}
