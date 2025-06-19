package dev.project.userservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {
    private  String name;
    private  String password;
    private  String email;
}
