package week6.PBL.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    @Override
    public void save(String name) {
        System.out.println("회원 저장 완료 : " + name);
    }
}