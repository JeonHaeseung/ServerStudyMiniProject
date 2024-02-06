package ServerStudyMiniProject.ServerStudyMiniProject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Circle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="circle_id")
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "circle") //외래키가 없으므로, MemberCircle 클래스의 member 필드로 역참조
    private List<MemberCircle> memberCircles = new ArrayList<>(); // MemberCircle 쪽이 다수이므로, List로 필드 만들기

    public Circle(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void changeDescription(String description){
        this.description = description;
    }
}
