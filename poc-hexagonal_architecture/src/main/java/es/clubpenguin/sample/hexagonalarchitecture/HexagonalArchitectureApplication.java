package es.clubpenguin.sample.hexagonalarchitecture;

import es.clubpenguin.sample.hexagonalarchitecture.application.ports.output.CategoryOutputPort;
import es.clubpenguin.sample.hexagonalarchitecture.application.ports.output.ProductOutputPort;
import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Category;
import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Product;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.entity.CategoryEntity;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.entity.ProductEntity;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.repository.CategoryRepository;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class HexagonalArchitectureApplication {

    @Autowired
    ProductRepository PuertoProducto;
    @Autowired
    CategoryRepository PuertoCategoria;


    public static void main(String[] args) {
        SpringApplication.run(HexagonalArchitectureApplication.class, args);
    }

    @Bean
    CommandLineRunner init() {return args ->{
        CategoryEntity categoria= new CategoryEntity(1L,"Ropa");
        PuertoCategoria.save(categoria);
        CategoryEntity categoria2= new CategoryEntity(2L,"Accesorio");
        PuertoCategoria.save(categoria2);
        CategoryEntity categoria3= new CategoryEntity(3L,"Ruana");
        PuertoCategoria.save(categoria3);

        List<CategoryEntity> categorias = new ArrayList<>();
        List<CategoryEntity> categorias2 = new ArrayList<>();
        List<CategoryEntity> categorias3 = new ArrayList<>();
        categorias.add(new CategoryEntity(1L, "Ropa"));
        categorias.add(new CategoryEntity(2L, "Accesorios"));

        // Crear una fecha para el campo createAt
        Date fechaCreacion = new Date(); // Usando la fecha actual

        // Crear un producto con los datos inventados
        ProductEntity producto = new ProductEntity(
                "Camisa de Seda", // name
                "Camisa elegante hecha a mano con seda de alta calidad", // description
                120.0, // price
                15, // stock
                "camisa, seda, elegante", // keyWords
                "Hecho a mano, tejido fino", // characteristics
                "https://hips.hearstapps.com/hmg-prod/images/guest-wears-a-white-shirt-fastened-in-the-front-during-news-photo-1164780124-1567079085.jpg?crop=1.00xw:0.753xh;0,0.240xh&resize=1200:*", // urlImagen
                categorias, // categories
                fechaCreacion // createAt
        );
        PuertoProducto.save(producto);

        categorias2.add(categoria);
        categorias2.add(categoria2);
        // Crear otros dos productos utilizando el constructor completo
        ProductEntity producto2 = new ProductEntity(
                6L,
                "Vestido de Noche",
                "Elegante vestido de noche hecho a mano con seda de alta calidad",
                450.0,
                12,
                "vestido, noche, seda, elegante",
                "Hecho a mano, tejido fino, diseño exclusivo",
                "https://static.zara.net/assets/public/07c7/6670/fce54274b4d4/a025dab6b9f2/02335173800-a4/02335173800-a4.jpg?ts=1712562753406&w=563",
                categorias2,
                fechaCreacion
        );
        PuertoProducto.save(producto2);



        categorias3.add(categoria);
        categorias3.add(categoria2);
        ProductEntity producto3 = new ProductEntity(
                7L,
                "Bufanda de Seda",
                "Bufanda suave y lujosa hecha de seda pura",
                80.0,
                30,
                "bufanda, seda, suave, lujosa",
                "100% seda, tejido delicado, perfecto para cualquier ocasión",
                "https://static.zara.net/assets/public/07c7/6670/fce54274b4d4/a025dab6b9f2/02335173800-a4/02335173800-a4.jpg?ts=1712562753406&w=563",
                categorias3,
                fechaCreacion
        );
        PuertoProducto.save(producto3);

    };
    }
}