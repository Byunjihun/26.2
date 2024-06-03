package hannamproject.hanpro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "member_table")
public class MemberEntity {
    @Id
    @Column
    private String studentId;

    @Column
    private String memberEmail;

    @Column
    private String userName;

    @Column
    private String memberPassword;

    @Column
    private String department;

    @Column
    private String year;

    @Column
    private Long graduationScore;
}
