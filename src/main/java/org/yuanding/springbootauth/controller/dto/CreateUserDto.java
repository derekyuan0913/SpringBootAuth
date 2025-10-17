package org.yuanding.springbootauth.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
public class CreateUserDto {

    public String userName;
    public String email;
    public String password;
    public String nickName;
}
