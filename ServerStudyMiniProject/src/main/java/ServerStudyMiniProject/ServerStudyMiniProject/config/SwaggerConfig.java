package ServerStudyMiniProject.ServerStudyMiniProject.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    private Info apiInfo() {
        return new Info()
                .title("GDSC Mini Project")
                .version("0.0.1")
                .description("GDSC의 미니 스프링 프로젝트 API 문서입니다.");
    }

    /*OpenAPI 객체를 생성하여 API 문서의 전반적인 구성을 설정
     * 앞서 설정한 Info 객체를 지정*/
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

}