package week8_9_10.PBL.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import week8_9_10.PBL.domain.Assignment;
import week8_9_10.PBL.domain.Member;
import week8_9_10.PBL.dto.request.AssignmentCreateRequest;
import week8_9_10.PBL.dto.request.AssignmentUpdateRequest;
import week8_9_10.PBL.repository.AssignmentRepository;
import week8_9_10.PBL.repository.MemberRepository;
import week8_9_10.PBL.global.exception.AssignmentNotFoundException;
import week8_9_10.PBL.global.exception.MemberNotFoundException;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final MemberRepository memberRepository;

    public AssignmentService(
            AssignmentRepository assignmentRepository,
            MemberRepository memberRepository
    ) {
        this.assignmentRepository = assignmentRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Assignment create(
            Long memberId,
            AssignmentCreateRequest request
    ) {

        Member member =
                memberRepository.findById(memberId)
                        .orElseThrow(
                                () -> new MemberNotFoundException(
                                        "해당 멤버를 찾을 수 없습니다. id: " + memberId
                                )
                        );

        Assignment assignment =
                new Assignment(
                        request.getTitle(),
                        request.getDescription(),
                        member
                );

        return assignmentRepository.save(assignment);
    }

    public List<Assignment> findByMemberId(Long memberId) {
        return assignmentRepository.findByMemberId(memberId);
    }

    public Assignment findById(Long id) {
        return assignmentRepository.findById(id)
                .orElseThrow(
                        () -> new AssignmentNotFoundException(
                                "해당 과제를 찾을 수 없습니다. id: " + id
                        )
                );
    }

    @Transactional
    public Assignment update(
            Long id,
            AssignmentUpdateRequest request
    ) {

        Assignment assignment =
                assignmentRepository.findById(id)
                        .orElseThrow(
                                () -> new AssignmentNotFoundException(
                                        "해당 과제를 찾을 수 없습니다. id: " + id
                                )
                        );

        assignment.updateInfo(
                request.getTitle(),
                request.getDescription()
        );

        return assignmentRepository.save(assignment);
    }

    @Transactional
    public void delete(Long id) {

        Assignment assignment =
                assignmentRepository.findById(id)
                        .orElseThrow(
                                () -> new AssignmentNotFoundException(
                                        "해당 과제를 찾을 수 없습니다. id: " + id
                                )
                        );

        assignmentRepository.delete(assignment);
    }

    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }

    public List<Assignment> searchByTitle(String keyword) {
        return assignmentRepository.findByTitleContaining(keyword);
    }
}