package ServerStudyMiniProject.ServerStudyMiniProject.auth.jwt;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class JwtToken {
    private String jwtAccessToken; //사용자가 자원에 접근할 수 있는 권한 부여

    @Builder
    public JwtToken(String jwtAccessToken) {
        this.jwtAccessToken = jwtAccessToken;
    }
}