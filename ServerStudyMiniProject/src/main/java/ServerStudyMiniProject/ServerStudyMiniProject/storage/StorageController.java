package ServerStudyMiniProject.ServerStudyMiniProject.storage;

import ServerStudyMiniProject.ServerStudyMiniProject.storage.dto.GetUrlDto;
import ServerStudyMiniProject.ServerStudyMiniProject.storage.dto.PutUrlDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Tag(name = "GCP Storage API", description = "signed-url 발급, 객체 URL 업로드 및 조회 API.")
public class StorageController {
    private final StorageService storageService;
    @PostMapping("/profile")
    @Operation(summary = "조회용 signed-url 발급 API", description = "클라이언트에게 조회용 signed-url 발급하는 API 입니다.")
    public ResponseEntity<String> getSignedUrl(@RequestBody GetUrlDto getUrlDto) throws IOException {
        String url = storageService.generateGetObjectSignedUrl(getUrlDto);
        return ResponseEntity.ok(url);
    }

    @PostMapping("/profile/upload")
    @Operation(summary = "업로드용 signed-url 발급 API", description = "클라이언트에게 업로드용 signed-url 발급하는 API 입니다.")
    public ResponseEntity<String> putSignedUrl(@RequestBody PutUrlDto putUrlDto){
        String url = storageService.generatePutObjectSignedUrl(putUrlDto);
        return ResponseEntity.ok(url);
    }

}
