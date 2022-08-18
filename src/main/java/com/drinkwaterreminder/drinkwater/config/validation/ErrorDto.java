package com.drinkwaterreminder.drinkwater.config.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorDto {
  private String field;
  private String error;
}
