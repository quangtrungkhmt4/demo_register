package com.demoregister.demo_register.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse extends AbstractResponse{
    private String token;
    private String userName;
    private String phone;
}
