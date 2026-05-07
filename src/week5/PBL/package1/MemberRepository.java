package week5.PBL.package1;

import week3.PBL.role.Person;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    private List<Person> members = new ArrayList<>();

    public void save(Person person) {
        members.add(person);
    }

    public List<Person> findAll() {
        return members;
    }

    public Person findByName(String name) {

        for (Person person : members) {
            if (person.getName().equals(name)) {
                return person;
            }
        }

        return null;
    }

    public boolean existsByName(String name) {

        for (Person person : members) {
            if (person.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}