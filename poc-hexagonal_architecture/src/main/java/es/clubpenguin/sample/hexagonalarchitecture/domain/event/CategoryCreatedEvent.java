package es.clubpenguin.sample.hexagonalarchitecture.domain.event;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryCreatedEvent {

    private Long id;

    private LocalDateTime date;

    public CategoryCreatedEvent(Long id) {
        this.id = id;
        this.date = LocalDateTime.now();
    }

}

