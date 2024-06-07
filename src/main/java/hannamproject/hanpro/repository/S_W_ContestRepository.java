package hannamproject.hanpro.repository;

import hannamproject.hanpro.entity.S_W_ContestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface S_W_ContestRepository extends JpaRepository<S_W_ContestEntity, Long> {
    List<S_W_ContestEntity> findByStudentId(String studentId);
}
