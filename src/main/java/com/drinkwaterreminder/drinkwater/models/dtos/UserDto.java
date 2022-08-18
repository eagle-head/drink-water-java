package com.drinkwaterreminder.drinkwater.models.dtos;

import com.drinkwaterreminder.drinkwater.enums.GenderEnum;
import com.drinkwaterreminder.drinkwater.validation.constraints.EnumNamePattern;
import lombok.*;

import javax.validation.constraints.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDto implements Serializable {
  @Serial
  private static final long serialVersionUID = -4993499572533026215L;

  private UUID id;
  @NotBlank
  private String name;
  @NotNull
  @Past
  private Date birthDate;
  @NotNull
  @DecimalMin(value = "45")
  @DecimalMax(value = "150")
  private BigDecimal weight;
  @NotNull
  @DecimalMin(value = "1")
  @DecimalMax(value = "2.10")
  private BigDecimal height;
  @EnumNamePattern(regexp = "MALE|FEMALE|OTHERS")
  private GenderEnum gender;
}
