package hannamproject.hanpro.entity;

import hannamproject.hanpro.dto.MemberDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "member_table")
public class MemberEntity {
    @Id
    private String memberStudentId;
    @Column
    private String memberEmail;
    @Column
    private String memberName;
    @Column
    private String memberPassword;
    @Column
    private String memberDepartment;
    @Column
    private Long memberGrade;
    @Column
    private Long memberGraduationScore;

    public static MemberEntity toMemberEntity(MemberDto memberDto){
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
