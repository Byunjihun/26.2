package hannamproject.hanpro.repository;

import hannamproject.hanpro.entity.GraduationExhibitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Graduation_ExhibitionRepository extends JpaRepository<GraduationExhibitionEntity, Long> {
    List<GraduationExhibitionEntity> findByStudentId(String studentId);
}
