package com.demoregister.demo_register.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest extends AbstractRequest{
    private Integer id;
    private String name;
    private String phone;
}
