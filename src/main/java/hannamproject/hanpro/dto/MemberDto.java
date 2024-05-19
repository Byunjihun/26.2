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

    public static MemberDto toMemberDto(MemberEntity memberEntity){
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
}
