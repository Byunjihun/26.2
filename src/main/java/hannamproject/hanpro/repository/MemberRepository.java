package hannamproject.hanpro.repository;

import hannamproject.hanpro.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {
    Optional<MemberEntity> findByMemberStudentId(String memberStudentId);
}
