package hannamproject.hanpro.repository;

import hannamproject.hanpro.entity.CertificateMajorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificateMajorRepository extends JpaRepository<CertificateMajorEntity, Long> {
    List<CertificateMajorEntity> findByStudentId(String studentId);
}
