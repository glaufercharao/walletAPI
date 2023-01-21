package com.wallet.main.services;

import com.wallet.main.entities.User;

import java.util.Optional;

public interface UserService {
    User save(User user);
    Optional<User> findByEmail(String email);
}
