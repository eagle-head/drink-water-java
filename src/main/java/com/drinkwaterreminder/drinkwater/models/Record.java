package com.drinkwaterreminder.drinkwater.models;

import com.drinkwaterreminder.drinkwater.enums.WeekDayEnum;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Record record = (Record) o;
    return id != null && Objects.equals(id, record.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
