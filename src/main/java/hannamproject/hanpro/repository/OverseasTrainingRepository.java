package hannamproject.hanpro.repository;

import hannamproject.hanpro.entity.OverseasTrainingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OverseasTrainingRepository extends JpaRepository<OverseasTrainingEntity, Long> {
    List<OverseasTrainingEntity> findByStudentId(String studentId);
}
