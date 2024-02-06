package ServerStudyMiniProject.ServerStudyMiniProject.post;

import ServerStudyMiniProject.ServerStudyMiniProject.domain.Post;
import ServerStudyMiniProject.ServerStudyMiniProject.post.dto.PostDeleteRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
@Tag(name = "포스트 관련 API", description = "Builder와 JpaRepository를 배우기 위한 컨트롤러입니다.")
public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;
    @GetMapping("")
    @Operation(summary = "포스트 조회 API", description = "모든 포스트를 조회하는 API 입니다.")
    public ResponseEntity<?> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return new ResponseEntity<>(posts, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("")
    @Operation(summary = "포스트 삭제 API", description = "포스트 ID 기반 삭제하는 API 입니다.")
    public ResponseEntity<?> deletePost(@RequestParam("postId") Long postId) {
        postService.deletePost(postId);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
