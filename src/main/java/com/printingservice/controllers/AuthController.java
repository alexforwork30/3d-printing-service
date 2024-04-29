package com.printingservice.controllers;

import com.printingservice.dtos.auth.request.LoginRQ;
import com.printingservice.dtos.auth.request.SignupRQ;
import com.printingservice.dtos.auth.response.LoginRP;
import com.printingservice.dtos.auth.response.SignupRP;
import com.printingservice.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;

  @PostMapping("/signup")
  public SignupRP signup(@Valid @RequestBody SignupRQ signupRQ) {
    return authService.signup(signupRQ);
  }

  @PostMapping("/login")
  public LoginRP login(@Valid @RequestBody LoginRQ loginRQ) {
    return authService.login(loginRQ);
  }
}
