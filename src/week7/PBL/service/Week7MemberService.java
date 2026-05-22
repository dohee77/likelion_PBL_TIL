package week7.PBL.service;

import org.springframework.stereotype.Service;
import week7.PBL.domain.role.Lion;
import week7.PBL.domain.role.Role;
import week7.PBL.domain.role.Staff;
import week7.PBL.dto.*;
import week7.PBL.repository.Week7MemberRepository;

@Service
public class Week7MemberService {

    private final Week7MemberRepository week7MemberRepository;

    public Week7MemberService(Week7MemberRepository week7MemberRepository) {
        this.week7MemberRepository = week7MemberRepository;
    }

    public Lion createLion(LionCreateRequest request) {

        if (week7MemberRepository.existsByName(request.getName())) {
            return null;
        }

        Lion lion = new Lion(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getStudentId()
        );

        week7MemberRepository.save(lion);

        return lion;
    }

    public Staff createStaff(StaffCreateRequest request) {

        if (week7MemberRepository.existsByName(request.getName())) {
            return null;
        }

        Staff staff = new Staff(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getPosition()
        );

        week7MemberRepository.save(staff);

        return staff;
    }

    public Role findMember(String name) {
        return week7MemberRepository.findByName(name);
    }

    public Lion updateLion(String name, LionUpdateRequest request) {

        Role existing = week7MemberRepository.findByName(name);

        if (existing == null || !(existing instanceof Lion)) {
            return null;
        }

        Lion updatedLion = new Lion(
                name,
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getStudentId()
        );

        week7MemberRepository.updateByName(name, updatedLion);

        return updatedLion;
    }

    public Staff updateStaff(String name, StaffUpdateRequest request) {

        Role existing = week7MemberRepository.findByName(name);

        if (existing == null || !(existing instanceof Staff)) {
            return null;
        }

        Staff updatedStaff = new Staff(
                name,
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getPosition()
        );

        week7MemberRepository.updateByName(name, updatedStaff);

        return updatedStaff;
    }

    public boolean deleteMember(String name) {
        return week7MemberRepository.deleteByName(name);
    }
}