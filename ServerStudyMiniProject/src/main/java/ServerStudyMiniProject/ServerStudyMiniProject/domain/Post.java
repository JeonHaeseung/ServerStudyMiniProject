package ServerStudyMiniProject.ServerStudyMiniProject.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    private LocalDateTime postDate;

    private String title;
    
    private String thumbnail; //bucket에서 생성된 URL 저장
    
    private String body;

    private int likes;


}
