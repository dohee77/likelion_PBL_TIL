package week5.PBL.package2;

import week3.PBL.role.Person;

import java.util.List;

public class MemberService {

    // 인터페이스 의존
    private final MemberRepository repository;

    // 생성자 주입 (DI)
    public MemberService(MemberRepository repository) {

        this.repository = repository;
    }

    // 등록
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