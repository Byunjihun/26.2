package hannamproject.hanpro.repository;

import hannamproject.hanpro.entity.CounselingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CounselingRepository extends JpaRepository<CounselingEntity, Long> {
    List<CounselingEntity> findByStudentId(String studentId);
}
