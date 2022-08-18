package com.drinkwaterreminder.drinkwater.exceptions;

import java.io.Serial;

public class IdNotFoundException extends RuntimeException {
  @Serial
  private static final long serialVersionUID = 8351758064300827516L;

  public IdNotFoundException(String message) {
    super(message);
  }
}
