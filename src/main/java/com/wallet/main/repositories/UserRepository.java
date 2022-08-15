package com.wallet.main.repositories;

import com.wallet.main.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
 Optional<User> findByEmail(String email);
}
