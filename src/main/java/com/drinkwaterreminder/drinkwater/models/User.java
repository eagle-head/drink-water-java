package com.drinkwaterreminder.drinkwater.models;

import com.drinkwaterreminder.drinkwater.enums.GenderEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_USER")
public class User implements Serializable {
  @Serial
  private static final long serialVersionUID = 2156347786773995335L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", columnDefinition = "uuid")
  private UUID id;
  @Column(name = "name")
  private String name;
  @Temporal(TemporalType.DATE)
  @JsonFormat(pattern = "yyyy-MM-dd")
  @Column(name = "birth_date")
  private Date birthDate;
  @Column(name = "weight")
  private BigDecimal weight;
  @Column(name = "height")
  private BigDecimal height;
  @Enumerated(EnumType.STRING)
  @Column(name = "gender")
  private GenderEnum gender;
  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @PrimaryKeyJoinColumn
  private SignIn signIn;
}
