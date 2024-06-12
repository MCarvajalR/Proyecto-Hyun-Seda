package es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    private int stock;

    private String keyWords;

    private String characteristics;

    private String urlImagen;

    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "id_category"))
    private List<CategoryEntity> categories = new ArrayList<>();

    //private Location location;

    //private User user;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    public ProductEntity(String name, String description, Double price, int stock, String keyWords,
                         String characteristics, String urlImagen, List<CategoryEntity> categories, Date createAt) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.keyWords = keyWords;
        this.characteristics = characteristics;
        this.urlImagen = urlImagen;
        this.categories = categories != null ? new ArrayList<>(categories) : new ArrayList<>();
        this.createAt = createAt != null ? new Date(createAt.getTime()) : new Date();
    }
}