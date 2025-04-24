package com.user_service.controller;

import com.user_service.dto.AddContactDto;
import com.user_service.dto.UserDto;
import com.user_service.entity.ContactDetails;
import com.user_service.entity.User;
import com.user_service.service.UserService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Data
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDto userDto, BindingResult result){
        if(result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors().toString());
        }
        User user=new User(userDto.getMobileNumber(),userDto.getEmailId(),userDto.getName(),userDto.getCreatedTime(),userDto.getUserStatus(),userDto.getContactDetails());
        System.out.println("user   = "+user.getEmailId());
        String response = userService.createUser(user);
        return ResponseEntity.ok("User Created Successfully"+response);
    }

    @PostMapping("/addContact")
    public ResponseEntity<String> addContact(@Valid @RequestBody AddContactDto contactDto, BindingResult result){
        if(result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors().toString());
        }
        System.out.println("user   = "+contactDto.getContactID());
        List<String> messages=new ArrayList<>();
        messages.add("1d");
        String response=userService.addContact(new ContactDetails(contactDto.getContactID(),messages),contactDto.getUserId());
        return ResponseEntity.ok(response);
    }
}