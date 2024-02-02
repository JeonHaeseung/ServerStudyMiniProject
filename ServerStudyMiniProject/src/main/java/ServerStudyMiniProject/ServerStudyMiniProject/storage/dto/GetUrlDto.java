package ServerStudyMiniProject.ServerStudyMiniProject.storage.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetUrlDto {
    @Schema(description = "조회할 이미지 이름", example = "gdsc.png")
    private String objectName;
}
