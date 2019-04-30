package com.codespells.Code.Spells.repository;

import com.codespells.Code.Spells.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(String email);
}
