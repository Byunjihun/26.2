package hannamproject.hanpro.repository;

import hannamproject.hanpro.entity.InternshipEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InternshipRepository extends JpaRepository<InternshipEntity, Long> {
    List<InternshipEntity> findByStudentId(String studentId);
}
