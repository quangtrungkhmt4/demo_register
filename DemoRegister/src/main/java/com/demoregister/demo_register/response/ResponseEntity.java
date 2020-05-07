package com.demoregister.demo_register.response;

import com.demoregister.demo_register.constant.ResponseCode;
import com.demoregister.demo_register.util.JsonUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEntity {

    private int code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AbstractResponse data;

    public ResponseEntity(int code) {
        this.code = code;
    }

    public ResponseEntity(AbstractResponse data) {
        this.code = ResponseCode.SUCCESS;
        this.data = data;
    }

    @Override
    public String toString() {
        return JsonUtil.castFromObject(this);
    }

}
