package hannamproject.hanpro.repository;

import hannamproject.hanpro.entity.GraduationEntity;
import hannamproject.hanpro.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GraduationRepository extends JpaRepository<GraduationEntity, String> {
    Optional<GraduationEntity> findByMemberStudentId(String memberStudentId);
}

