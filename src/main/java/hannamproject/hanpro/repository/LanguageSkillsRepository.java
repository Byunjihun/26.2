package hannamproject.hanpro.repository;

import hannamproject.hanpro.entity.LanguageSkillsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageSkillsRepository extends JpaRepository<LanguageSkillsEntity, Long> {
    List<LanguageSkillsEntity> findByStudentId(String studentId);
}
