package week6.PBL.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import week6.PBL.repository.MemberRepository;
import week6.PBL.repository.MemoryMemberRepository;
import week6.PBL.service.MemberService;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
}