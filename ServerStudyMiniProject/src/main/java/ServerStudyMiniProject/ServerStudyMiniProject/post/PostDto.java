package ServerStudyMiniProject.ServerStudyMiniProject.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {
    @Schema(description = "포스트 생성 날짜", example = "2024-01-28 12:34:56")
    private LocalDateTime postDate;

    @Schema(description = "포스트 제목", example = "테크")
    private String title;

    @Schema(description = "포스트 썸네일 URL")
    private String thumbnail; //GCP bucket에서 생성된 URL 저장

    @Schema(description = "포스트 본문", example = "Dto에 대해서 배워보겠습니다. Dto는...")
    private String body;

    @Schema(description = "포스트 좋아요 수", example = "1000")
    private int likes;
}
