package com.drinkwaterreminder.drinkwater.models.mappers;

import com.drinkwaterreminder.drinkwater.models.User;
import com.drinkwaterreminder.drinkwater.models.dtos.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
  final ModelMapper mapper;

  public User convertToUser(UserDto dto){
    return mapper.map(dto, User.class);
  }

  public UserDto convertToUserDto(User user){
    return mapper.map(user, UserDto.class);
  }

  public Page<User> convertToPageUser(Page<UserDto> dtoPage){
    return dtoPage.map(this::convertToUser);
  }

  public Page<UserDto> convertToPageUserDto(Page<User> userPage){
    return userPage.map(this::convertToUserDto);
  }
}