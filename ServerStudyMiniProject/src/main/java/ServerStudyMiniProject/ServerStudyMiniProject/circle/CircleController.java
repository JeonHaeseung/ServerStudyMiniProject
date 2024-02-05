package ServerStudyMiniProject.ServerStudyMiniProject.circle;

import ServerStudyMiniProject.ServerStudyMiniProject.circle.dto.CircleCreateRequestDto;
import ServerStudyMiniProject.ServerStudyMiniProject.circle.dto.CircleUpdateRequestDto;
import ServerStudyMiniProject.ServerStudyMiniProject.domain.Circle;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "서클 관련 API", description = "JPA의 자동 변경 감지용 컨트롤러입니다.")
public class CircleController {
    private final CircleService circleService;
    private final CircleRepository circleRepository;

    @PostMapping("/circle/new")
    @Operation(summary = "서클 생성 API", description = "서클 정보를 바탕으로 새로운 서클을 생성하는 API 입니다.")
    public ResponseEntity<?> makeNewCircle(@RequestBody CircleCreateRequestDto circleCreateRequestDto) {
        /* 저장만 하는 간단한 API이므로, Service 사용하지 말고 바로 Repository 사용 */
        Circle circle = new Circle(circleCreateRequestDto.getName(), circleCreateRequestDto.getDescription());
        circleRepository.save(circle);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @PostMapping("/circle/update")
    @Operation(summary = "서클 업데이트 API", description = "서클 설명을 업데이트하는 API 입니다.")
    public ResponseEntity<?> updateOriginalCircle(@RequestBody CircleUpdateRequestDto circleUpdateRequestDto) {
        /* 변경 감지를 사용할 때는 반드시 서비스 객체에 위임할 것! */
        circleService.updateCircleDesc(circleUpdateRequestDto.getId(), circleUpdateRequestDto.getDescription());
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }


}
