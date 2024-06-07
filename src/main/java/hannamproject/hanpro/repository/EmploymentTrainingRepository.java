package hannamproject.hanpro.repository;

import hannamproject.hanpro.entity.EmploymentTrainingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmploymentTrainingRepository extends JpaRepository<EmploymentTrainingEntity, Long> {
    List<EmploymentTrainingEntity> findByStudentId(String studentId);
}
