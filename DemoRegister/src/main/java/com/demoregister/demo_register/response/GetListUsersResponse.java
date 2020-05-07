package com.demoregister.demo_register.response;

import com.demoregister.demo_register.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListUsersResponse extends AbstractResponse{
    private List<User> users;
}
