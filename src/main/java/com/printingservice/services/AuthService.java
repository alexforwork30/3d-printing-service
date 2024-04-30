package com.printingservice.services;

import com.printingservice.dtos.auth.request.LoginReq;
import com.printingservice.dtos.auth.request.SignupReq;
import com.printingservice.dtos.auth.response.LoginRes;
import com.printingservice.dtos.auth.response.SignupRes;
import com.printingservice.enums.user.ERole;
import com.printingservice.models.User;
import com.printingservice.models.UserCredential;
import com.printingservice.repositories.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final UserRepository userRepository;
  private final JwtService jwtService;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;

  public SignupRes signup(SignupReq signupReq) {
    SignupReq.UserCredential userCredentialRQ = signupReq.getUserCredential();

    User user =
        User.builder()
            .fullName(signupReq.getFullName())
            .email(signupReq.getEmail())
            .phoneNumber(signupReq.getPhoneNumber())
            .address(signupReq.getAddress())
            .build();

    UserCredential userCredential =
        UserCredential.builder()
            .username(userCredentialRQ.getUsername())
            .password(passwordEncoder.encode(userCredentialRQ.getPassword()))
            .build();

    user.setUserCredential(userCredential);
    userCredential.setUser(user);
    userRepository.save(user);

    return SignupRes.builder().username(userCredential.getUsername()).build();
  }

  public LoginRes login(LoginReq loginReq) {
    Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginReq.getUsername(), loginReq.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String token = jwtService.generateToken(authentication);
    Optional<String> authority =
        authentication.getAuthorities().stream().findFirst().map(GrantedAuthority::getAuthority);
    if (authority.isEmpty()) {
      throw new RuntimeException("Role not found");
    }
    ERole role = ERole.valueOf(authority.get());

    return LoginRes.builder().token(token).role(role).build();
  }
}
