package es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.repository;

import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Product;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    /**
     * @brief Busca productos por categoría.
     * Este método busca productos por la categoría especificada.
     * @param categoryId ID de la categoría por la cual filtrar los productos.
     * @return Lista de productos que pertenecen a la categoría especificada.
     */
    @Query("SELECT p FROM ProductEntity p JOIN p.categories c WHERE c.id_category = :categoryId")
    List<ProductEntity> findByCategoriesCategoryId(@Param("categoryId") Long categoryId);
}
