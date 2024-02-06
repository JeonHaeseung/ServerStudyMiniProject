package ServerStudyMiniProject.ServerStudyMiniProject.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostListResponseDto {
    private List<PostDto> posts;
}
