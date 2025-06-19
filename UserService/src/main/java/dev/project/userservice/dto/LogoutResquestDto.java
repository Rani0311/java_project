package dev.project.userservice.dto;

import dev.project.userservice.model.Token;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogoutResquestDto {
    private String token;
}
