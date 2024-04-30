package com.printingservice.dtos.auth.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignupReq {
  @NotBlank private String fullName;

  @NotBlank private String email;

  @NotBlank private String phoneNumber;

  @NotBlank private String address;

  @NotNull private UserCredential userCredential;

  @NoArgsConstructor
  @AllArgsConstructor
  @Data
  public static class UserCredential {
    @NotBlank private String username;

    @NotBlank private String password;
  }
}
