package ServerStudyMiniProject.ServerStudyMiniProject.post;

import ServerStudyMiniProject.ServerStudyMiniProject.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService  {
    private final PostRepository postRepository;
    public void deletePost(Long postId){
        Post post = postRepository.findPostById(postId);
        postRepository.delete(post);
    }

    public PostListResponseDto findAllPosts(){
        List<Post> postList = postRepository.findAll();

        // PostListResponseDTO에 매핑
        List<PostDto> postDtos = postList.stream()
                .map(post -> new PostDto.PostDtoBuilder()
                        .postDate(post.getPostDate())
                        .title(post.getTitle())
                        .body(post.getBody())
                        .likes(post.getLikes())
                        .thumbnail(post.getThumbnail())
                        .build())
                .toList();

        return new PostListResponseDto(postDtos);
    }

}
