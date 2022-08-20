package com.drinkwaterreminder.drinkwater.services;

import com.drinkwaterreminder.drinkwater.repositories.SignInRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignInService {

  private final SignInRepository signInRepository;

  public boolean existsByEmail(String email) {
    return signInRepository.existsByEmail(email);
  }
}
