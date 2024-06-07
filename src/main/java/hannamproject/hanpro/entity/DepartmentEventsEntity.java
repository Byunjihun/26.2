package hannamproject.hanpro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// 학과 행사 참여 실적
// 세미나, 현장견학: 건당 30점
// 학과 임원활동, MT, 체육대회, 학술제 등: 건당 20점, 최대 300점
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "department_events_table")
public class DepartmentEventsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentId;

    private int eventsScore;
    private String scoreName;

    @ManyToOne
    @JoinColumn(name = "studentId", insertable = false, updatable = false)
    private MemberEntity member;
}
