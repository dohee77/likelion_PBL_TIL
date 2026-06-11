package week8_9_10.PBL.service;

import org.springframework.stereotype.Service;
import week8_9_10.PBL.domain.Member;
import week8_9_10.PBL.domain.RoleType;
import week8_9_10.PBL.dto.request.*;
import week8_9_10.PBL.repository.MemberRepository;
import week8_9_10.PBL.global.exception.DuplicateMemberException;
import week8_9_10.PBL.global.exception.MemberNotFoundException;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Member createLion(LionCreateRequest request) {

        memberRepository.findByName(request.getName())
                .ifPresent(member -> {
                    throw new DuplicateMemberException(
                            "이미 존재하는 이름입니다. name: "
                                    + request.getName()
                    );
                });

        Member member = new Member(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                RoleType.LION,
                request.getStudentId(),
                null
        );
        return memberRepository.save(member);
    }

    @Transactional
    public Member createStaff(StaffCreateRequest request) {

        memberRepository.findByName(request.getName())
                .ifPresent(member -> {
                    throw new DuplicateMemberException(
                            "이미 존재하는 이름입니다. name: "
                                    + request.getName()
                    );
                });

        Member member = new Member(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                RoleType.STAFF,
                null,
                request.getPosition()
        );
        return memberRepository.save(member);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public List<Member> findByPart(String part) {
        return memberRepository.findByPart(part);
    }

    public Member findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(
                        () -> new MemberNotFoundException(
                                "해당 멤버를 찾을 수 없습니다. id: " + id
                        )
                );
    }

    @Transactional
    public Member updateLion(Long id, LionUpdateRequest request) {
        Member member = memberRepository.findById(id)
                .orElseThrow(
                        () -> new MemberNotFoundException(
                                "해당 멤버를 찾을 수 없습니다. id: " + id
                        )
                );

        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updateStudentId(request.getStudentId());

        return memberRepository.save(member);
    }

    @Transactional
    public Member updateStaff(Long id, StaffUpdateRequest request) {
        Member member = memberRepository.findById(id)
                .orElseThrow(
                        () -> new MemberNotFoundException(
                                "해당 멤버를 찾을 수 없습니다. id: " + id
                        )
                );

        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updatePosition(request.getPosition());

        return memberRepository.save(member);
    }

    @Transactional
    public void delete(Long id) {

        Member member = memberRepository.findById(id)
                .orElseThrow(
                        () -> new MemberNotFoundException(
                                "해당 멤버를 찾을 수 없습니다. id: " + id
                        )
                );

        memberRepository.delete(member);
    }
}