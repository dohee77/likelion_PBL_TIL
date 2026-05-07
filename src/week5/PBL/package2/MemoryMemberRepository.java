package week5.PBL.package2;

import week3.PBL.role.Person;

import java.util.ArrayList;
import java.util.List;

public class MemoryMemberRepository implements MemberRepository {

    private List<Person> members = new ArrayList<>();

    // 저장
    @Override
    public void save(Person person) {

        members.add(person);
    }

    // 전체 조회
    @Override
    public List<Person> findAll() {

        return members;
    }

    // 이름 검색
    @Override
    public Person findByName(String name) {

        for (Person person : members) {

            if (person.getName().equals(name)) {

                return person;
            }
        }

        return null;
    }

    // 이름 중복 확인
    @Override
    public boolean existsByName(String name) {

        for (Person person : members) {

            if (person.getName().equals(name)) {

                return true;
            }
        }

        return false;
    }
}