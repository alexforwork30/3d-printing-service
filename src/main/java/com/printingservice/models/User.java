package com.printingservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class User extends Base {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 100, nullable = false)
  private String fullName;

  @Column(nullable = false, unique = true)
  @Email
  private String email;

  @Column(length = 20, nullable = false)
  private String phoneNumber;

  @Column(nullable = false)
  private String address;

  @Column private String avatarUrl;

  @OneToOne(
      mappedBy = "user",
      cascade = CascadeType.ALL,
      fetch = FetchType.LAZY,
      orphanRemoval = true)
  @PrimaryKeyJoinColumn
  private UserCredential userCredential;
}
