package com.demoregister.demo_register.response;

import com.demoregister.demo_register.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertUserResponse extends AbstractResponse{
    private User user;
}
