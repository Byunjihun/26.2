package hannamproject.hanpro.service;

import hannamproject.hanpro.dto.MemberDto;
import hannamproject.hanpro.entity.MemberEntity;
import hannamproject.hanpro.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository  memberRepository;

    public MemberDto login(MemberDto memberDto){
        Optional<MemberEntity> byMember_student_id = memberRepository.findByMemberStudentId(memberDto.getMemberStudentId());
        if (byMember_student_id.isPresent()){
            MemberEntity memberEntity = byMember_student_id.get();
            if (memberEntity.getMemberPassword().equals(memberDto.getMemberPassword())){
                MemberDto dto = MemberDto.toMemberDto(memberEntity);
                return dto;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }
}
