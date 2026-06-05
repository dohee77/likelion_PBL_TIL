package week8ㅣ9.PBL.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import week8ㅣ9.PBL.domain.Member;
import week8ㅣ9.PBL.dto.response.MemberResponse;
import week8ㅣ9.PBL.dto.request.*;
import week8ㅣ9.PBL.service.MemberService;

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
    public List<MemberResponse> findAll() {
        return memberService.findAll()
                .stream()
                .map(MemberResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MemberResponse findById(@PathVariable Long id) {
        Member member = memberService.findById(id);
        return (member == null) ? null : new MemberResponse(member);
    }

    @PutMapping("/lions/{id}")
    public MemberResponse updateLion(@PathVariable Long id,
                                     @RequestBody LionUpdateRequest request) {
        Member member = memberService.updateLion(id, request);
        return (member == null) ? null : new MemberResponse(member);
    }

    @PutMapping("/staffs/{id}")
    public MemberResponse updateStaff(@PathVariable Long id,
                                      @RequestBody StaffUpdateRequest request) {
        Member member = memberService.updateStaff(id, request);
        return (member == null) ? null : new MemberResponse(member);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        memberService.delete(id);
        return ResponseEntity.noContent().build();
    }
}