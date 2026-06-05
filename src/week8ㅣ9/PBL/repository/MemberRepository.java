package week8ㅣ9.PBL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import week8ㅣ9.PBL.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}