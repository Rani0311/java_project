package dev.project.userservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResponseDto {

    private String name;
    private String email;
    private  ResponseStatus responseStatus;
}
