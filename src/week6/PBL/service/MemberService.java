package week6.PBL.service;

import org.springframework.stereotype.Service;
import week6.PBL.repository.MemberRepository;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    // 생성자가 1개라 @Autowired 생략 가능
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void join(String name) {
        memberRepository.save(name);
    }
}