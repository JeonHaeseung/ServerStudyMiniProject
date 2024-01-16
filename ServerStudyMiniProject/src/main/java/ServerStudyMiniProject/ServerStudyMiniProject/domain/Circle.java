package ServerStudyMiniProject.ServerStudyMiniProject.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Circle {
    @Id
    @GeneratedValue
    @Column(name="circle_id")
    private Long id;

    private String name;

    private String desc;

    @OneToMany(mappedBy = "circle") //외래키가 없으므로, MemberCircle 클래스의 member 필드로 역참조
    private List<MemberCircle> memberCircles = new ArrayList<>(); // MemberCircle 쪽이 다수이므로, List로 필드 만들기
}
