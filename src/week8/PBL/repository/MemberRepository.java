package week8.PBL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import week8.PBL.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}