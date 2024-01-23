package ServerStudyMiniProject.ServerStudyMiniProject.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {
    @Schema(description = "나라", example = "한국")
    private String country;

    @Schema(description = "도시", example = "서울")
    private String city;

    @Schema(description = "우편번호", example = "12345")
    private String zipcode;
}
