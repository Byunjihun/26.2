package hannamproject.hanpro.repository;

import hannamproject.hanpro.entity.MemberImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberImageRepository extends JpaRepository<MemberImage, Long> {
    Optional<MemberImage> findByStudentId(String studentId);
}
