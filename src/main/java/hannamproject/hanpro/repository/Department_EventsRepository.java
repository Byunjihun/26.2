package hannamproject.hanpro.repository;

import hannamproject.hanpro.entity.DepartmentEventsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Department_EventsRepository extends JpaRepository<DepartmentEventsEntity, Long> {
    List<DepartmentEventsEntity> findByStudentId(String studentId);
}
