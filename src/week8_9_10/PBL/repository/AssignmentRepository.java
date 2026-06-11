package week8_9_10.PBL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import week8_9_10.PBL.domain.Assignment;

import java.util.List;

public interface AssignmentRepository
        extends JpaRepository<Assignment, Long> {

    List<Assignment> findByMemberId(Long memberId);

    List<Assignment> findByTitleContaining(String keyword);

}