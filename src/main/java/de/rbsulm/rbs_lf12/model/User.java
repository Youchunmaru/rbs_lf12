package de.rbsulm.rbs_lf12.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Column(unique=true, nullable=false)
  private String username;

  @Column(nullable=false)
  private String password;

  @Column(nullable=false)
  private boolean enabled;

  private String email;


}