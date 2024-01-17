package ServerStudyMiniProject.ServerStudyMiniProject.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;

    private String email;

    private String password;

    private int age;

    private String name;

    @Embedded
    private Address address;

    @OneToOne(mappedBy = "member") //외래키가 없으므로, Profile 클래스의 member 필드로 역참조
    private Profile profile;

    @OneToMany(mappedBy = "member") //외래키가 없으므로, Post 클래스의 member 필드로 역참조
    private List<Post> posts = new ArrayList<>(); // Post 쪽이 다수이므로, List로 필드 만들기

    @OneToMany(mappedBy = "member") //외래키가 없으므로, MemberCircle 클래스의 member 필드로 역참조
    private List<MemberCircle> memberCircles = new ArrayList<>(); // MemberCircle 쪽이 다수이므로, List로 필드 만들기
}
