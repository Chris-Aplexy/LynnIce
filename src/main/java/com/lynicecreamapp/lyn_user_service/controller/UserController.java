package com.lynicecreamapp.lyn_user_service.controller;

import com.lynicecreamapp.lyn_user_service.model.User;
import com.lynicecreamapp.lyn_user_service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    Logger logger = LoggerFactory.getLogger("");

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody @Valid User user){
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> viewUser(@PathVariable long userId){
        User user = userService.ViewUser(userId);
        if(user == null) return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        log.info("user viewed");
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<@Valid User>> viewUserList(){
        List<User> users = userService.viewAllUsers();
        if(users == null) return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        log.info("user list viewed");
        return new ResponseEntity<>(userService.viewAllUsers(),HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<@Valid User> updateUserInfo(@PathVariable long userId, @RequestBody @Valid User user){
        User user1 = userService.ViewUser(userId);
        if(user1 == null) return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        log.info("userinfo updated");
        return new ResponseEntity<>(userService.updateUser(userId, user), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable long userId){
        User user = userService.ViewUser(userId);
        if(user == null) return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        log.info("user deleted");
        return new ResponseEntity<>(userService.deleteUserById(userId), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteMultipleUsersById(@RequestBody List<Long> idList){
        log.info("users selected deleted");
        return new ResponseEntity<>(userService.deleteMultipleById(idList),HttpStatus.OK);
    }

}
