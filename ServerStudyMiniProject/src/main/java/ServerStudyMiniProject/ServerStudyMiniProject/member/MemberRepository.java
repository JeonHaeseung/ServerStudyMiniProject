package ServerStudyMiniProject.ServerStudyMiniProject.member;

import ServerStudyMiniProject.ServerStudyMiniProject.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //CRUD 연산 메서드, 쿼리 메서드를 이미 지원하는 JpaRepository 상속
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findMemberById(Long memberId);

    // 특정 맴버 이메일로 맴버 엔티티 반환
    Member findMemberByEmail(String email);
}
