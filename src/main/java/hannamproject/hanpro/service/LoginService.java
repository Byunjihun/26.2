package hannamproject.hanpro.service;

import hannamproject.hanpro.dto.MemberDto;
import hannamproject.hanpro.entity.MemberEntity;
import hannamproject.hanpro.repository.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    @PostConstruct
    public void migratePasswords() {
        List<MemberEntity> members = memberRepository.findAll();
        for (MemberEntity member : members) {
            if (!isBCryptEncoded(member.getMemberPassword())) {
                logger.info("Migrating password for user: {}", member.getStudentId());
                String encodedPassword = passwordEncoder.encode(member.getMemberPassword());
                member.setMemberPassword(encodedPassword);
                memberRepository.save(member);
            }
        }
    }

    private boolean isBCryptEncoded(String password) {
        return password != null && password.startsWith("$2a$");
    }

    public void register(MemberDto memberDto) {
        // 비밀번호 인코딩
        String encodedPassword = passwordEncoder.encode(memberDto.getMemberPassword());
        memberDto.setMemberPassword(encodedPassword);

        MemberEntity memberEntity = MemberDto.toMemberEntity(memberDto);
        memberRepository.save(memberEntity);
    }

    public MemberDto login(String studentId, String password) {
        logger.info("Attempting to log in with studentId: {}", studentId);

        Optional<MemberEntity> byStudentId = memberRepository.findByStudentId(studentId);
        if (byStudentId.isPresent()) {
            MemberEntity memberEntity = byStudentId.get();
            logger.info("Found user: {}", memberEntity);

            // 비밀번호 비교
            if (passwordEncoder.matches(password, memberEntity.getMemberPassword())) {
                logger.info("Passwords match");
                return MemberDto.toMemberDto(memberEntity);
            } else {
                logger.info("Passwords do not match");
            }
        } else {
            logger.info("No user found with studentId: {}", studentId);
        }
        return null;
    }

    public Optional<MemberDto> getMemberDetails(String studentId) {
        return memberRepository.findByStudentId(studentId).map(MemberDto::toMemberDto);
    }

    public Optional<List<String>> getSkills(String studentId) {
        return memberRepository.findByStudentId(studentId).map(MemberEntity::getSkills);
    }

    public Optional<Boolean> hasSkill(String studentId, String skill) {
        return memberRepository.findByStudentId(studentId)
                .map(member -> member.getSkills().contains(skill));
    }

    public Optional<Map<String, Boolean>> getSubjects(String studentId) {
        return memberRepository.findByStudentId(studentId).map(MemberEntity::getSubjects);
    }

    public Optional<Boolean> getSubject(String studentId, String subject) {
        return memberRepository.findByStudentId(studentId)
                .map(member -> member.getSubjects().get(subject));
    }
}
