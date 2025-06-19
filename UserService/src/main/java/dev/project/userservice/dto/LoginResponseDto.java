package dev.project.userservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LoginResponseDto {
    private String tokenValue;
    private Date expireAt;
    private String email;

}
