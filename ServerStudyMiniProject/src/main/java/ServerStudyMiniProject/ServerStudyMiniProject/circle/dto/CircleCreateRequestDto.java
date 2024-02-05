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
public class CircleCreateRequestDto {
    @Schema(description = "새로 만들 서클 이름", example = "GDSC Ewha")
    private String name;

    @Schema(description = "새로 만들 서클 설명", example = "GDSC Ewha를 위한 서클입니다.")
    private String description;
}
