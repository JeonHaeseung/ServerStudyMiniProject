package ServerStudyMiniProject.ServerStudyMiniProject.circle;

import ServerStudyMiniProject.ServerStudyMiniProject.domain.Circle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import jakarta.persistence.EntityManager;

@Repository
public interface CircleRepository extends JpaRepository<Circle, Long> {
    Circle findCircleById(Long circleID);

    /* 업데이트를 구현할 때, 이렇게 구현하지 않습니다.
     * 대신 JPA의 자동 변경 감지를 사용합니다.
    private final EntityManager em;
    public void save(Circle circle){
        if (circle.getId() == null){
            em.persist(item); // JPA에서 처음 저장하기 전까지는 id 값이 없다.
            // 즉, 완전히 새로 생성하는 객체이다.
        } else {
            em.merge(item); // 두 번째 저장할 때는 다음과 같이 해준다. 업데이트와 비슷하다.
        }
    }
     */
}
