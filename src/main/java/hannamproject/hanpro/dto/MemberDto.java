package hannamproject.hanpro.dto;

import hannamproject.hanpro.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDto {
    private String memberStudentId;
    private String memberEmail;
    private String memberName;
    private String memberPassword;
    private String memberDepartment;
    private Long memberGrade;
    private Long memberGraduationScore;
    private boolean rememberMe; // 아이디 기억 옵션 추가

    public static MemberDto toMemberDto(MemberEntity memberEntity) {
        MemberDto memberDto = new MemberDto();
        memberDto.setMemberStudentId(memberEntity.getMemberStudentId());
        memberDto.setMemberEmail(memberEntity.getMemberEmail());
        memberDto.setMemberName(memberEntity.getMemberName());
        memberDto.setMemberPassword(memberEntity.getMemberPassword());
        memberDto.setMemberDepartment(memberEntity.getMemberDepartment());
        memberDto.setMemberGrade(memberEntity.getMemberGrade());
        memberDto.setMemberGraduationScore(memberEntity.getMemberGraduationScore());
        return memberDto;
    }

    public static MemberEntity toMemberEntity(MemberDto memberDto) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberStudentId(memberDto.getMemberStudentId());
        memberEntity.setMemberEmail(memberDto.getMemberEmail());
        memberEntity.setMemberName(memberDto.getMemberName());
        memberEntity.setMemberPassword(memberDto.getMemberPassword());
        memberEntity.setMemberDepartment(memberDto.getMemberDepartment());
        memberEntity.setMemberGrade(memberDto.getMemberGrade());
        memberEntity.setMemberGraduationScore(memberDto.getMemberGraduationScore());
        return memberEntity;
    }
}
