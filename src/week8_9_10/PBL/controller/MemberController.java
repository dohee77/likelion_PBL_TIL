package week8_9_10.PBL.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import week8_9_10.PBL.domain.Member;
import week8_9_10.PBL.dto.response.MemberResponse;
import week8_9_10.PBL.dto.request.*;
import week8_9_10.PBL.service.MemberService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/lions")
    public ResponseEntity<MemberResponse> createLion(@RequestBody LionCreateRequest request) {
        return ResponseEntity.status(201)
                .body(new MemberResponse(memberService.createLion(request)));
    }

    @PostMapping("/staffs")
    public ResponseEntity<MemberResponse> createStaff(@RequestBody StaffCreateRequest request) {
        return ResponseEntity.status(201)
                .body(new MemberResponse(memberService.createStaff(request)));
    }

    @GetMapping
    public List<MemberResponse> findAll(
            @RequestParam(required = false) String part
    ) {

        List<Member> members;

        if (part == null) {
            members = memberService.findAll();
        } else {
            members = memberService.findByPart(part);
        }

        return members.stream()
                .map(MemberResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MemberResponse findById(
            @PathVariable Long id
    ) {
        return new MemberResponse(
                memberService.findById(id)
        );
    }

    @PutMapping("/lions/{id}")
    public MemberResponse updateLion(@PathVariable Long id,
                                     @RequestBody LionUpdateRequest request) {
        return new MemberResponse(
                memberService.updateLion(id, request)
        );
    }

    @PutMapping("/staffs/{id}")
    public MemberResponse updateStaff(@PathVariable Long id,
                                      @RequestBody StaffUpdateRequest request) {
        return new MemberResponse(
                memberService.updateStaff(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        memberService.delete(id);
        return ResponseEntity.noContent().build();
    }
}