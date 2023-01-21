package com.wallet.main.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet.main.dtos.UserDto;
import com.wallet.main.entities.User;
import com.wallet.main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> save(@Valid @RequestBody UserDto dto, BindingResult result) {
        ObjectMapper mapper = new ObjectMapper();
        UserDto dtoReturn = mapper.convertValue(userService.save(this.convertDtoEntitry(dto)), UserDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoReturn);
    }

    private User convertDtoEntitry(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
