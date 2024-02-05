package ServerStudyMiniProject.ServerStudyMiniProject.circle;

import ServerStudyMiniProject.ServerStudyMiniProject.domain.Circle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CircleService {
    private final CircleRepository circleRepository;

    public void updateCircleDesc(Long id, String description){
        /* JPA의 변경 감지를 사용하면, 단순히 DB에서 꺼내온 엔티티의 필드를 변경해주기만 해도
         * 자동으로 변경이 감지되고, 변경사항이 트랜잭션에 의해서 커밋된다.
         */
        Circle circle = circleRepository.findCircleById(id);
        /* Setter를 사용하는 것보다, changeDescription라는 명확한 메서드를 통해
         * 어떤 상황에서 값이 변경된 것인지를 tracking 되게 만들어준다.
         */
        circle.changeDescription(description);
    }
}
