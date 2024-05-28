package hannamproject.hanpro.service;

import hannamproject.hanpro.entity.GraduationEntity;
import hannamproject.hanpro.repository.GraduationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GraduationService {
    private final GraduationRepository graduationRepository;

    public Optional<GraduationEntity> findGraduationScore(String memberStudentId){
        return graduationRepository.findByMemberStudentId(memberStudentId);
    }
}