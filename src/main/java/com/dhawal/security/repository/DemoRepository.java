package com.dhawal.security.repository;

import com.dhawal.security.models.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DemoRepository extends JpaRepository<DemoEntity, Long> {
}
