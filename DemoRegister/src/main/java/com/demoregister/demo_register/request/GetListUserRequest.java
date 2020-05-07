package com.demoregister.demo_register.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListUserRequest extends AbstractRequest{
    private String token;
    private int page;
    private String name;
}
