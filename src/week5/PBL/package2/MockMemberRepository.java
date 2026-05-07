package week5.PBL.package2;

import week3.PBL.role.Lion;
import week3.PBL.role.Person;

import java.util.ArrayList;
import java.util.List;

public class MockMemberRepository implements MemberRepository {

    private List<Person> mockMembers = new ArrayList<>();

    // 생성자
    public MockMemberRepository() {

        // 더미 데이터
        mockMembers.add(
                new Lion(
                        "김사자",
                        "컴퓨터공학과",
                        14,
                        "백엔드",
                        "202020202"
                )
        );
    }

    // 저장 X
    @Override
    public void save(Person person) {

        System.out.println("⚠ Mock 저장소에서는 저장되지 않습니다.");
    }

    // 전체 조회
    @Override
    public List<Person> findAll() {

        return mockMembers;
    }

    // 이름 검색
    @Override
    public Person findByName(String name) {

        for (Person person : mockMembers) {

            if (person.getName().equals(name)) {

                return person;
            }
        }

        return null;
    }

    // 이름 중복 확인
    @Override
    public boolean existsByName(String name) {

        for (Person person : mockMembers) {

            if (person.getName().equals(name)) {

                return true;
            }
        }

        return false;
    }
}