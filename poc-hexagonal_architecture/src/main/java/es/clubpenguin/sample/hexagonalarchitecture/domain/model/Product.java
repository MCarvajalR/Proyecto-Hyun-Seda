package es.clubpenguin.sample.hexagonalarchitecture.domain.model;

import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

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
