package ServerStudyMiniProject.ServerStudyMiniProject.domain;

import ServerStudyMiniProject.ServerStudyMiniProject.auth.dto.AddressDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;

    @Column(nullable = false) //null 값이 되어서는 안 된다.
    private String email;

    @Column(nullable = false) //null 값이 되어서는 안 된다.
    private String password;

    private int age;

    private String name;

    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;

    @Embedded
    private Address address;

    @OneToOne(mappedBy = "member") //외래키가 없으므로, Profile 클래스의 member 필드로 역참조
    private Profile profile;

    @OneToMany(mappedBy = "member") //외래키가 없으므로, Post 클래스의 member 필드로 역참조
    private List<Post> posts = new ArrayList<>(); // Post 쪽이 다수이므로, List로 필드 만들기

    @OneToMany(mappedBy = "member") //외래키가 없으므로, MemberCircle 클래스의 member 필드로 역참조
    private List<MemberCircle> memberCircles = new ArrayList<>(); // MemberCircle 쪽이 다수이므로, List로 필드 만들기

    public Member(String email, String password, int age, String name, MemberRole memberRole, Address address){
        this.email = email;
        this.password = password;
        this.age = age;
        this.name = name;
        this.memberRole = Objects.requireNonNullElse(memberRole, memberRole.ROLE_USER); //값이 없다면, ROLE_USER로 초기화
        this.address = address;
    }
}
