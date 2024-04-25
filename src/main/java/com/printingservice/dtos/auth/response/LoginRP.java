package com.printingservice.dtos.auth.response;

import com.printingservice.enums.user.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LoginRP {
    private String token;
    private ERole role;
}
