package week7.PBL.repository;

import org.springframework.stereotype.Repository;
import week7.PBL.domain.role.Role;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Week7MemoryMemberRepository implements Week7MemberRepository {

    private final List<Role> members = new ArrayList<>();

    @Override
    public void save(Role member) {
        members.add(member);
    }

    @Override
    public Role findByName(String name) {

        for (Role member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }

        return null;
    }

    @Override
    public void updateByName(String name, Role updatedMember) {

        for (int i = 0; i < members.size(); i++) {

            if (members.get(i).getName().equals(name)) {
                members.set(i, updatedMember);
                return;
            }
        }
    }

    @Override
    public boolean deleteByName(String name) {
        return members.removeIf(member ->
                member.getName().equals(name));
    }

    @Override
    public boolean existsByName(String name) {

        for (Role member : members) {
            if (member.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}