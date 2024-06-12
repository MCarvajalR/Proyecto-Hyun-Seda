package es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.data.response;

import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Category;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.entity.CategoryEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductQueryResponse {

    private Long id;

    private String name;

    private String description;

    private Double price;

    private int stock;

    private String keyWords;

    private String characteristics;

    private String urlImagen;

    private List<Category> categories = new ArrayList<>();

}
