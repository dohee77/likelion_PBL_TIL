package week7.PBL.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import week7.PBL.domain.role.Lion;
import week7.PBL.domain.role.Role;
import week7.PBL.domain.role.Staff;
import week7.PBL.dto.*;
import week7.PBL.service.Week7MemberService;

@RestController
@RequestMapping("/members")
public class Week7MemberController {

    private final Week7MemberService week7MemberService;

    public Week7MemberController(Week7MemberService week7MemberService) {
        this.week7MemberService = week7MemberService;
    }

    @PostMapping("/lions")
    public ResponseEntity<LionResponse> createLion(
            @RequestBody LionCreateRequest request
    ) {

        Lion lion = week7MemberService.createLion(request);

        if (lion == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(LionResponse.from(lion));
    }

    @PostMapping("/staffs")
    public ResponseEntity<StaffResponse> createStaff(
            @RequestBody StaffCreateRequest request
    ) {

        Staff staff = week7MemberService.createStaff(request);

        if (staff == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(StaffResponse.from(staff));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findMember(@PathVariable String name) {

        Role member = week7MemberService.findMember(name);

        if (member == null) {
            return ResponseEntity.notFound().build();
        }

        if (member instanceof Lion lion) {
            return ResponseEntity.ok(LionResponse.from(lion));
        }

        if (member instanceof Staff staff) {
            return ResponseEntity.ok(StaffResponse.from(staff));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/lions/{name}")
    public ResponseEntity<LionResponse> updateLion(
            @PathVariable String name,
            @RequestBody LionUpdateRequest request
    ) {

        Lion lion = week7MemberService.updateLion(name, request);

        if (lion == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(LionResponse.from(lion));
    }

    @PutMapping("/staffs/{name}")
    public ResponseEntity<StaffResponse> updateStaff(
            @PathVariable String name,
            @RequestBody StaffUpdateRequest request
    ) {

        Staff staff = week7MemberService.updateStaff(name, request);

        if (staff == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(StaffResponse.from(staff));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteMember(
            @PathVariable String name
    ) {

        boolean deleted = week7MemberService.deleteMember(name);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}