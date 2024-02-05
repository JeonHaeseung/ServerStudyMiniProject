package ServerStudyMiniProject.ServerStudyMiniProject.circle.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CircleUpdateRequestDto {
    @Schema(description = "업데이트할 서클의 ID", example = "1")
    private Long id;

    @Schema(description = "업데이트할 서클 설명", example = "GDSC Ewha 서버 파트를 위한 서클입니다.")
    private String description;
}
