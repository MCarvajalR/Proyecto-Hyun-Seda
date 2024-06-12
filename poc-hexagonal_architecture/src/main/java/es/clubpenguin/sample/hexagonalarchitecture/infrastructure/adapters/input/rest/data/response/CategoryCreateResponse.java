package es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.data.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreateResponse {

    private Long id_category;
    private String name;

}
