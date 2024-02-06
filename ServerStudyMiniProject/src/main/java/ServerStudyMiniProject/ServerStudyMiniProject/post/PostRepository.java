package ServerStudyMiniProject.ServerStudyMiniProject.post;

import ServerStudyMiniProject.ServerStudyMiniProject.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    //findAll, save와 같은 함수는 기본 내장되어 있습니다.

    Post findPostById(Long postId);
}
