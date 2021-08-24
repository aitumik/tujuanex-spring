package com.aitumik.tujuanex.users.repository;

import com.aitumik.tujuanex.users.models.ERole;
import com.aitumik.tujuanex.users.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
}
