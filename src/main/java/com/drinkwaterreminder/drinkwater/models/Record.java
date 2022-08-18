package com.drinkwaterreminder.drinkwater.models;

import com.drinkwaterreminder.drinkwater.enums.WeekDayEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "TB_RECORD")
public class Record implements Serializable {
  @Serial
  private static final long serialVersionUID = -311876946486987822L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id", nullable = false, columnDefinition = "uuid")
  private UUID id;
  @Column(name = "time", nullable = false)
  private final LocalDateTime time = LocalDateTime.now();
  @Column(name = "volume_consumed", nullable = false)
  private double volumeConsumed;
  @Enumerated(EnumType.STRING)
  @Column(name = "week_day", nullable = false)
  private WeekDayEnum weekday;
}
