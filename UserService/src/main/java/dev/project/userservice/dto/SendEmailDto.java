package dev.project.userservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendEmailDto {
    private String to;
    private String subject;
    private String body;
    //private  String cc;

    private  String from;
}
