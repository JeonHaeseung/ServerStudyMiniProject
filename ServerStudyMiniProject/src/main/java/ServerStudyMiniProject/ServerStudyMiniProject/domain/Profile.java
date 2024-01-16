package ServerStudyMiniProject.ServerStudyMiniProject.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Profile {
    @Id
    @GeneratedValue
    @Column(name = "profile_id")
    private Long id;

    private String picture; //S3 bucket에서 생성된 URL 저장

    @Enumerated(EnumType.STRING)
    private Status status;

    private String intro;

    @OneToOne
    @JoinColumn(name = "member_id") //외래키
    private Member member;

}
