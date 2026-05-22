package com.Boltabay_Zhaniya.taskmanagement.repository;
import com.Boltabay_Zhaniya.taskmanagement.entity.Boltabay_Zhaniya_Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Boltabay_Zhaniya_RoleRepository extends JpaRepository<Boltabay_Zhaniya_Role, Long> {

    Optional<Boltabay_Zhaniya_Role> findByName(String name);
}