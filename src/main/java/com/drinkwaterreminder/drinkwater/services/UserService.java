package com.drinkwaterreminder.drinkwater.services;

import com.drinkwaterreminder.drinkwater.models.User;
import com.drinkwaterreminder.drinkwater.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
  final UserRepository userRepository;

  @Transactional
  public User saveUser(User user) {
    return userRepository.save(user);
  }

  public Optional<User> findUserById(UUID id) {
    return userRepository.findById(id);
  }

  public Page<User> findAllUsers(Pageable pageable) {
    return userRepository.findAll(pageable);
  }

  @Transactional
  public User update(User user) {
    return userRepository.save(user);
  }

  @Transactional
  public void delete(UUID id) {
    userRepository.deleteById(id);
  }
}
