package hannamproject.hanpro.dto;

import hannamproject.hanpro.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDto {
    private String studentId;
    private String memberEmail;
    private String userName;
    private String memberPassword;
    private String department;
    private String year;
    private Long graduationScore; // Ensure this is Long
    private Integer maxScore; // Ensure this is Integer
    private List<String> skills;
    private Map<String, Boolean> subjects;

    public static MemberDto toMemberDto(MemberEntity memberEntity) {
        MemberDto memberDto = new MemberDto();
        memberDto.setStudentId(memberEntity.getStudentId());
        memberDto.setMemberEmail(memberEntity.getMemberEmail());
        memberDto.setUserName(memberEntity.getUserName());
        memberDto.setMemberPassword(memberEntity.getMemberPassword());
        memberDto.setDepartment(memberEntity.getDepartment());
        memberDto.setYear(memberEntity.getYear());
        memberDto.setGraduationScore(memberEntity.getGraduationScore());
        memberDto.setMaxScore(memberEntity.getMaxScore());
        memberDto.setSkills(memberEntity.getSkills()); // Ensure these methods exist
        memberDto.setSubjects(memberEntity.getSubjects()); // Ensure these methods exist
        return memberDto;
    }

    public static MemberEntity toMemberEntity(MemberDto memberDto) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setStudentId(memberDto.getStudentId());
        memberEntity.setMemberEmail(memberDto.getMemberEmail());
        memberEntity.setUserName(memberDto.getUserName());
        memberEntity.setMemberPassword(memberDto.getMemberPassword());
        memberEntity.setDepartment(memberDto.getDepartment());
        memberEntity.setYear(memberDto.getYear());
        memberEntity.setGraduationScore(memberDto.getGraduationScore());
        memberEntity.setMaxScore(memberDto.getMaxScore());
        memberEntity.setSkills(memberDto.getSkills()); // Ensure these methods exist
        memberEntity.setSubjects(memberDto.getSubjects()); // Ensure these methods exist
        return memberEntity;
    }
}
