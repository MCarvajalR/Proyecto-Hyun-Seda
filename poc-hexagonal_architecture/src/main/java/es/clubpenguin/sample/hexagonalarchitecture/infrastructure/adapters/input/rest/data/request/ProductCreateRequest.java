package es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.data.request;

import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Category;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.entity.CategoryEntity;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequest {

    @NotEmpty(message = "Name may not be empty")
    private String name;

    @NotEmpty(message = "Description may not be empty")
    private String description;

    private Double price;

    private int stock;

    private String keyWords;

    private String characteristics;

    private String urlImagen;

    private List<Category> categories = new ArrayList<>();

}
