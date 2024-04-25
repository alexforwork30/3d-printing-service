package com.printingservice.services;

import com.printingservice.dtos.auth.request.LoginRQ;
import com.printingservice.dtos.auth.request.SignupRQ;
import com.printingservice.dtos.auth.response.LoginRP;
import com.printingservice.dtos.auth.response.SignupRP;
import com.printingservice.enums.user.ERole;
import com.printingservice.models.User;
import com.printingservice.models.UserCredential;
import com.printingservice.repositories.UserCredentialRepository;
import com.printingservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final UserCredentialRepository userCredentialRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public SignupRP signup(SignupRQ signupRQ) {
        SignupRQ.UserCredential userCredentialRQ = signupRQ.getUserCredential();

        User user = User.builder()
                .fullName(signupRQ.getFullName())
                .email(signupRQ.getEmail())
                .phoneNumber(signupRQ.getPhoneNumber())
                .address(signupRQ.getAddress())
                .build();

        UserCredential userCredential = UserCredential.builder()
                .username(userCredentialRQ.getUsername())
                .password(passwordEncoder.encode(userCredentialRQ.getPassword()))
                .build();

        user.setUserCredential(userCredential);
        userCredential.setUser(user);
        userRepository.save(user);

        return SignupRP.builder()
                .username(userCredential.getUsername())
                .build();
    }

    public LoginRP login(LoginRQ loginRQ) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRQ.getUsername(), loginRQ.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtService.generateToken(authentication);
        Optional<String> authority = authentication.getAuthorities().stream()
                .findFirst()
                .map(GrantedAuthority::getAuthority);
        ERole role = ERole.valueOf(authority.orElse(ERole.CUSTOMER.name()));

        return LoginRP.builder()
                .token(token)
                .role(role)
                .build();
    }
}
