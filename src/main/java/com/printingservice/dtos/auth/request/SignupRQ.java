package com.printingservice.dtos.auth.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignupRQ {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private UserCredential userCredential;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class UserCredential {
        private String username;
        private String password;
    }
}
