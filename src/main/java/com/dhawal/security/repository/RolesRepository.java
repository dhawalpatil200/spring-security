package com.dhawal.security.repository;

import com.dhawal.security.models.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(String user);
}
