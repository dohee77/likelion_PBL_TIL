package week8_9_10.PBL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import week8_9_10.PBL.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByName(String name);

    List<Member> findByPart(String part);
}