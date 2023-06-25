package com.spring.petabyte.repository;

import com.spring.petabyte.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Optional<Permission> findByName(String name);
    Optional<Permission> findByValue(String value);

}
