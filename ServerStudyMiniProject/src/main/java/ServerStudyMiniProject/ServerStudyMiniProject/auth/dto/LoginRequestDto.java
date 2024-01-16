package ServerStudyMiniProject.ServerStudyMiniProject.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequestDto {
    /* 사용자의 이메일과 비밀번호로 로그인 */
    String email;
    String password;
}