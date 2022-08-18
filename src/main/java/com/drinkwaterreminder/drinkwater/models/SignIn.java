package com.drinkwaterreminder.drinkwater.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;


@Getter
@Setter
@ToString
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    SignIn signIn = (SignIn) o;
    return id != null && Objects.equals(id, signIn.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
