package com.demoregister.demo_register.cache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Session {

    private String token;
    private Integer userId;
    private Long lastRequestTime;

}
