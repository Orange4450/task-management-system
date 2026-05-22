package com.Boltabay_Zhaniya.taskmanagement.repository;
import com.Boltabay_Zhaniya.taskmanagement.entity.Boltabay_Zhaniya_User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Boltabay_Zhaniya_UserRepository extends JpaRepository<Boltabay_Zhaniya_User, Long> {
    Optional<Boltabay_Zhaniya_User> findByEmail(String email);
}
