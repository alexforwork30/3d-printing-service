package com.printingservice.controllers;

import com.printingservice.dtos.auth.request.LoginReq;
import com.printingservice.dtos.auth.request.SignupReq;
import com.printingservice.dtos.auth.response.LoginRes;
import com.printingservice.dtos.auth.response.SignupRes;
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
  public SignupRes signup(@Valid @RequestBody SignupReq signupReq) {
    return authService.signup(signupReq);
  }

  @PostMapping("/login")
  public LoginRes login(@Valid @RequestBody LoginReq loginReq) {
    return authService.login(loginReq);
  }
}
