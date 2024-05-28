package hannamproject.hanpro.repository;

import hannamproject.hanpro.entity.GraduationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GraduationRepository extends JpaRepository<GraduationEntity,String> {
    Optional<GraduationEntity> findByMemberStudentId(String memberStudentId);
}