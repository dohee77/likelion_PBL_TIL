package week5.PBL.package1;

import week3.PBL.role.Person;

import java.util.List;

public class MemberService {

    // Step1 핵심 : 직접 생성 (강한 결합)
    private MemberRepository repository = new MemberRepository();

    // 멤버 등록
    public boolean register(Person person) {

        // 중복 확인
        if (repository.existsByName(person.getName())) {
            return false;
        }

        repository.save(person);
        return true;
    }

    // 전체 조회
    public List<Person> getAllMembers() {
        return repository.findAll();
    }

    // 이름 검색
    public Person searchByName(String name) {
        return repository.findByName(name);
    }
}