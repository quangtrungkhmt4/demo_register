package com.demoregister.demo_register.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertUserRequest extends AbstractRequest{
    private String name;
    private String phone;
}
