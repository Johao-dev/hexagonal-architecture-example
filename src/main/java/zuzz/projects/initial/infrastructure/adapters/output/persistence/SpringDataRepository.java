package zuzz.projects.initial.infrastructure.adapters.output.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import zuzz.projects.initial.infrastructure.adapters.output.persistence.entity.SpendEntity;

public interface SpringDataRepository extends CrudRepository<SpendEntity, Long>{

    @Query("SELECT s FROM SpendEntity s WHERE s.category = :category")
    List<SpendEntity> findByCategory(@Param("category") String category);
}
