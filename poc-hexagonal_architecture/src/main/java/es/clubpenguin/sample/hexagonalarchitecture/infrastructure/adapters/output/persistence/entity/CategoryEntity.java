package es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_category;
    private String name;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private List<ProductEntity> products = new ArrayList<>();

    public CategoryEntity(Long id_category, String name) {
        this.id_category = id_category;
        this.name = name;
        this.products = new ArrayList<>();
    }

}