package week8ㅣ9.PBL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import week8ㅣ9.PBL.domain.Assignment;

import java.util.List;

public interface AssignmentRepository
        extends JpaRepository<Assignment, Long> {

    List<Assignment> findByMemberId(Long memberId);

}