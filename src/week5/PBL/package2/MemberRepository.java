package week5.PBL.package2;

import week3.PBL.role.Person;

import java.util.List;

public interface MemberRepository {

    // 저장
    void save(Person person);

    // 전체 조회
    List<Person> findAll();

    // 이름 검색
    Person findByName(String name);

    // 이름 중복 확인
    boolean existsByName(String name);
}