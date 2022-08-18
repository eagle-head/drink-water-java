package com.drinkwaterreminder.drinkwater.controllers;

import com.drinkwaterreminder.drinkwater.models.User;
import com.drinkwaterreminder.drinkwater.models.dtos.UserDto;
import com.drinkwaterreminder.drinkwater.models.mappers.UserMapper;
import com.drinkwaterreminder.drinkwater.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/users")
@RequiredArgsConstructor
public class UserController {

  final UserService userService;
  final UserMapper userMapper;

  //  CREATE /*****************************/

  @PostMapping
  public ResponseEntity<Object> createUser(@RequestBody @Valid UserDto userDto) {
    User user = userService.saveUser(userMapper.convertToUser(userDto));
    userDto.setId(user.getId());

    return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
  }

  //  READ /*****************************/

  @GetMapping
  public ResponseEntity<Page<UserDto>> getAllUsers(@PageableDefault(page = 0, size = 10, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
    Page<User> userPage = userService.findAllUsers(pageable);

    return ResponseEntity.status(HttpStatus.OK).body(userMapper.convertToPageUserDto(userPage));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getUserById(@PathVariable(value = "id") UUID id) {
    Optional<User> userOptional = userService.findUserById(id);

    if (userOptional.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
    }

    return ResponseEntity.status(HttpStatus.FOUND).body(userMapper.convertToUserDto(userOptional.get()));
  }

  //  UPDATE /*****************************/

  @PutMapping("/{id}")
  public ResponseEntity<Object> updateUserById(@PathVariable(value = "id") UUID id, @RequestBody @Valid UserDto userDto) {
    if (userService.findUserById(id).isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No users found.");
    }

    User userUpdated = userMapper.convertToUser(userDto);
    userUpdated.setId(id);

    return ResponseEntity.status(HttpStatus.FOUND).body(userService.update(userUpdated));
  }

  //  DELETE /*****************************/

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteUserById(@PathVariable UUID id) {
    if (userService.findUserById(id).isEmpty()) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No user with id " + id + " exists!");
    }

    userService.delete(id);

    return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");
  }
}
