package com.drinkwaterreminder.drinkwater.models.mappers;

import com.drinkwaterreminder.drinkwater.models.User;
import com.drinkwaterreminder.drinkwater.models.dtos.RegisterDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
  final ModelMapper mapper;

  public User convertToUser(RegisterDto dto) {
    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

    return mapper.map(dto, User.class);
  }

  public RegisterDto convertToUserDto(User user) {
    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

    return mapper.map(user, RegisterDto.class);
  }

  public Page<User> convertToPageUser(Page<RegisterDto> dtoPage) {
    return dtoPage.map(this::convertToUser);
  }

  public Page<RegisterDto> convertToPageUserDto(Page<User> userPage) {
    return userPage.map(this::convertToUserDto);
  }
}