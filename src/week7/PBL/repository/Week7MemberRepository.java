package week7.PBL.repository;

import week7.PBL.domain.role.Role;

public interface Week7MemberRepository {

    void save(Role member);

    Role findByName(String name);

    void updateByName(String name, Role member);

    boolean deleteByName(String name);

    boolean existsByName(String name);
}