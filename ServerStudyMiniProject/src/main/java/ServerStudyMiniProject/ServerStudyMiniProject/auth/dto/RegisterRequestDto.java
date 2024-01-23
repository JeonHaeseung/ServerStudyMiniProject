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
public class RegisterRequestDto {
    @Schema(description = "사용자의 이메일 주소", example = "1234@email.com")
    private String email;

    @Schema(description = "사용자의 비밀번호", example = "abc123!#")
    private String password;

    @Schema(description = "나이", example = "20")
    private int age;

    @Schema(description = "이름", example = "홍길동")
    private String name;

    private AddressDto addressDto;
}
