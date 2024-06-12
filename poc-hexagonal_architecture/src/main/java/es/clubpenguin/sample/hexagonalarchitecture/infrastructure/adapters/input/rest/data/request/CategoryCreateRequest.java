package es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.data.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreateRequest {

    private String name;

}
