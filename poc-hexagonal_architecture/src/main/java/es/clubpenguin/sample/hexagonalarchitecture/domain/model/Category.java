package es.clubpenguin.sample.hexagonalarchitecture.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private Long id_category;
    private String name;

}
