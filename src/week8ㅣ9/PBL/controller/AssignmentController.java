package week8ㅣ9.PBL.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import week8ㅣ9.PBL.domain.Assignment;
import week8ㅣ9.PBL.dto.request.AssignmentCreateRequest;
import week8ㅣ9.PBL.dto.request.AssignmentUpdateRequest;
import week8ㅣ9.PBL.dto.response.AssignmentResponse;
import week8ㅣ9.PBL.service.AssignmentService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(
            AssignmentService assignmentService
    ) {
        this.assignmentService = assignmentService;
    }

    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<AssignmentResponse> create(
            @PathVariable Long memberId,
            @RequestBody AssignmentCreateRequest request
    ) {

        Assignment assignment =
                assignmentService.create(memberId, request);

        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(201)
                .body(new AssignmentResponse(assignment));
    }

    @GetMapping("/members/{memberId}/assignments")
    public List<AssignmentResponse> findByMemberId(
            @PathVariable Long memberId
    ) {

        return assignmentService.findByMemberId(memberId)
                .stream()
                .map(AssignmentResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> findById(
            @PathVariable Long id
    ) {

        Assignment assignment =
                assignmentService.findById(id);

        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                new AssignmentResponse(assignment)
        );
    }

    @PutMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> update(
            @PathVariable Long id,
            @RequestBody AssignmentUpdateRequest request
    ) {

        Assignment assignment =
                assignmentService.update(id, request);

        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                new AssignmentResponse(assignment)
        );
    }

    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {

        assignmentService.delete(id);

        return ResponseEntity.noContent().build();
    }
}