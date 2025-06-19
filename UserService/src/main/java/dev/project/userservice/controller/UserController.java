package dev.project.userservice.controller;

import dev.project.userservice.dto.*;
import dev.project.userservice.dto.ResponseStatus;
import dev.project.userservice.model.Token;
import dev.project.userservice.model.User;
import dev.project.userservice.service.UserService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


   @PostMapping("/signup")
  public SignupResponseDto signup(@RequestBody SignupRequestDto signupRequestDto)
  {

          String name = signupRequestDto.getName();
          String email = signupRequestDto.getEmail();
          String password = signupRequestDto.getPassword();

      SignupResponseDto signupResponseDto=new SignupResponseDto();

      try {
          User user=userService.signup(name, email, password);
          signupResponseDto.setName(user.getName());
          signupResponseDto.setEmail(user.getEmail());
          signupResponseDto.setResponseStatus(ResponseStatus.FAILURE);
      }catch (Exception e)
      {
          signupResponseDto.setResponseStatus(ResponseStatus.FAILURE);
      }
      return signupResponseDto;

  }
  @PostMapping("/login")
    public  LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto)
    {
         Token token=userService.login(loginRequestDto.getEmail(),loginRequestDto.getPassword());

         LoginResponseDto loginResponseDto=new LoginResponseDto();
         loginResponseDto.setEmail(token.getUser().getEmail());
         loginResponseDto.setTokenValue(token.getValue());
         loginResponseDto.setExpireAt(token.getExpiryAt());
         return  loginResponseDto;

    }
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutResquestDto logoutRequestDto)
    {
        userService.logout(logoutRequestDto.getToken());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/validate/{token}")
     public UserDto validateToken(@PathVariable("token") @NotNull String token)
    {
       return UserDto.from( userService.validateToken(token));

    }

}
