package ServerStudyMiniProject.ServerStudyMiniProject.storage;

import ServerStudyMiniProject.ServerStudyMiniProject.storage.dto.GetUrlDto;
import ServerStudyMiniProject.ServerStudyMiniProject.storage.dto.PutUrlDto;
import com.google.cloud.storage.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@Transactional(readOnly = true)
public class StorageService {

    @Value(value = "${storage.bucket}")
    private String bucket;

    @Value(value = "${storage.project-id}")
    private String projectId;

    /* 이미지를 조회하기 위해서 필요한 URL 발급 프로세스 */
    @Transactional
    public String generateGetObjectSignedUrl (GetUrlDto getUrlDto) throws StorageException {
        Storage storage = StorageOptions
                .newBuilder()
                .setProjectId(projectId)
                .build()
                .getService();

        String objectName = getUrlDto.getObjectName();

        BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of(bucket, objectName)).build();

        URL url = storage.signUrl(
                blobInfo,
                15,
                TimeUnit.MINUTES,
                Storage.SignUrlOption.withV4Signature());

        return url.toString();
    }

    /* 이미지를 저장하기 위해서 위해서 필요한 URL 발급 프로세스 */
    @Transactional
    public String generatePutObjectSignedUrl(PutUrlDto putUrlDto) throws StorageException {
        Storage storage = StorageOptions
                .newBuilder()
                .setProjectId(projectId)
                .build()
                .getService();

        String objectName = putUrlDto.getObjectName();
        String contentType = putUrlDto.getContentType();

        BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of(bucket, objectName)).build();

        Map<String, String> extensionHeaders = new HashMap<>();
        extensionHeaders.put("Content-Type", contentType);

        URL url = storage.signUrl(
                        blobInfo,
                        15,
                        TimeUnit.MINUTES,
                        Storage.SignUrlOption.httpMethod(HttpMethod.PUT),
                        Storage.SignUrlOption.withExtHeaders(extensionHeaders),
                        Storage.SignUrlOption.withV4Signature());

        return url.toString();
    }
}
