package com.drinkwaterreminder.drinkwater.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;


@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "TB_SIGNIN")
public class SignIn implements Serializable {
  @Serial
  private static final long serialVersionUID = 7102208483370873639L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id", nullable = false, columnDefinition = "uuid")
  private UUID id;
  @Column(name = "email", nullable = false, unique = true)
  private String email;
  @Column(name = "password", nullable = false)
  private String password;
}
