package es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.data.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryQueryResponse {

    private Long id_category;
    private String name;

}
