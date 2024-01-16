package ServerStudyMiniProject.ServerStudyMiniProject.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

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

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Member(String email, String password, Authority authority) {
        this.email = email;
        this.password = password;
        this.authority = authority;
    }
}
