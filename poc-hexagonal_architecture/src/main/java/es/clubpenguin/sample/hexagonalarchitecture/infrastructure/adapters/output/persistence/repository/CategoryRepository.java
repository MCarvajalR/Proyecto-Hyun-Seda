package es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.entity.CategoryEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
