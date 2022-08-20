package com.drinkwaterreminder.drinkwater.repositories;

import com.drinkwaterreminder.drinkwater.models.SignIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SignInRepository extends JpaRepository<SignIn, UUID> {

  abstract boolean existsByEmail(String email);
}