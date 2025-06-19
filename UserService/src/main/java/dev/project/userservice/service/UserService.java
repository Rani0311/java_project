package dev.project.userservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.project.userservice.dto.SendEmailDto;
import dev.project.userservice.model.Token;
import dev.project.userservice.model.User;
import dev.project.userservice.repository.TokenRepository;
import dev.project.userservice.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;


@Service
@Getter
@Setter
public class UserService {
      private BCryptPasswordEncoder bCryptPasswordEncoder;
      private UserRepository userRepository;
      private TokenRepository tokenRepository;
      private KafkaTemplate<String,String> kafkaTemplate;
      private ObjectMapper objectMapper;


      public  UserService(BCryptPasswordEncoder bCryptPasswordEncoder,
                          UserRepository userRepository,TokenRepository tokenRepository,
                          KafkaTemplate kafkaTemplate,
                          ObjectMapper objectMapper) {
          this.bCryptPasswordEncoder = bCryptPasswordEncoder;
          this.userRepository = userRepository;
          this.tokenRepository = tokenRepository;
          this.kafkaTemplate = kafkaTemplate;
          this.objectMapper = objectMapper;
      }

    public User signup(String fullName, String email, String password) throws JsonProcessingException {
        User user = new User();
        user.setName(fullName);
        user.setEmail(email);
        user.setHashedPassword(bCryptPasswordEncoder.encode(password));
        userRepository.save(user);
        SendEmailDto sendEmailDto=new SendEmailDto();
        sendEmailDto.setTo("padmarani.patil42@gmail.com");
        sendEmailDto.setSubject("Patil 42");
        sendEmailDto.setBody("Patil 42");
       // sendEmailDto.setFrom("ranisamratpatil@gmail.com");
        kafkaTemplate.send("Send_Email",objectMapper.writeValueAsString(sendEmailDto));

        return user;

    }
    public Token login(String email, String password)
    {
        Optional<User> optionalUser= userRepository.findByEmail(email);
        if(optionalUser.isEmpty())
        {
            //return null;
        }
        User user = optionalUser.get();
        if(!bCryptPasswordEncoder.matches(password,user.getHashedPassword()))
        {
            //password invalid exception
            return  null;

        }
        LocalDate localDate=LocalDate.now();
        LocalDate expiryDate = localDate.plusDays(30);
        Date expireDateLater = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());


        Token token = new Token();
        token.setExpiryAt(expireDateLater);
        token.setUser(user);
        token.setValue(RandomStringUtils.randomAlphanumeric(128));
        Token saveToken = tokenRepository.save(token);
        return saveToken;

    }
    public  void logout(String token)
    {
      Optional<Token> optionalToken= tokenRepository.findByValueAndDeletedEquals(token,false);
      if(optionalToken.isEmpty())
      {
          //return the exception token doesn't exist
          return;
      }
      Token token1=optionalToken.get();
      token1.setDeleted(true);
        tokenRepository.save(token1);
        return;

    }
    public  User validateToken(String token)
    {
        Optional<Token> optionalToken = tokenRepository.findByValueAndDeletedEqualsAndExpiryAtGreaterThan(token, false, new Date());

        if(optionalToken.isEmpty())
        {
            return null;
        }
        return  optionalToken.get().getUser();
    }

}
