package com.my_home.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "[user]")
@Entity(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String username;

  private String password;

  private String firstName;

  private String lastName;

  private Integer active;

  public User(RequestUser requestUser) {
    this.username = requestUser.username();
    this.password = requestUser.password();
    this.firstName = requestUser.firstName();
    this.lastName = requestUser.lastName();
    this.active = 1;
  }

}
