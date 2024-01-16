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

    private String picture;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String intro;

}
