package ServerStudyMiniProject.ServerStudyMiniProject.auth;

import ServerStudyMiniProject.ServerStudyMiniProject.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //CRUD 연산 메서드, 쿼리 메서드를 이미 지원하는 JpaRepository 상속
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email); //이메일로 맴버 객체 검색 후 반환
}
