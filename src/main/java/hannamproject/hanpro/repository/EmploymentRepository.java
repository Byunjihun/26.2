package hannamproject.hanpro.repository;

import hannamproject.hanpro.entity.EmploymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmploymentRepository extends JpaRepository<EmploymentEntity, Long> {
    List<EmploymentEntity> findByStudentId(String studentId);
}
