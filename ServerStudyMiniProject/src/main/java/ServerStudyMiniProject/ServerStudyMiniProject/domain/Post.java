package ServerStudyMiniProject.ServerStudyMiniProject.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private LocalDateTime postDate;

    private String title;
    
    private String thumbnail; //S3 bucket에서 생성된 URL 저장
    
    private String body;

    private int likes;

    @ManyToOne
    @JoinColumn(name = "member_id") //외래키
    private Member member;

    /* 비즈니스 로직 */
    public void addLikes(){
        this.likes+=1;
    }

    public void deleteLikes(){
        this.likes-=1;
    }

    @Builder
    public Post(LocalDateTime postDate, String title, String thumbnail, String body, int likes){
        this.postDate = postDate;
        this.title = title;
        this.thumbnail = thumbnail;
        this.body = body;
        this.likes = likes;
    }

}
