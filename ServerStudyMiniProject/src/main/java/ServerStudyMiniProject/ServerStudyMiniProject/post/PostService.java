package ServerStudyMiniProject.ServerStudyMiniProject.post;

import ServerStudyMiniProject.ServerStudyMiniProject.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService  {
    private final PostRepository postRepository;
    public void deletePost(Long postId){
        Post post = postRepository.findPostById(postId);
        postRepository.delete(post);
    }

}
