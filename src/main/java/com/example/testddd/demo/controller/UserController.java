package com.example.testddd.demo.controller;

import com.example.testddd.demo.aspect.TokenRequired;
import com.example.testddd.demo.dto.UserDTO;
import com.example.testddd.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    //CRUD
    // C -> POST
    // R -> GET
    // U -> PUT
    // D -> DELETE


    @PostMapping("")
    public UserDTO insertUser(@RequestBody UserDTO user){
        return userService.insertUser(user);
    }

    @GetMapping("")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @TokenRequired
    @GetMapping("/{userId}")
    public UserDTO getUserByUserId(@PathVariable String userId){
        return userService.getUserByUserId(userId);
    }

    @PutMapping("/{userId}")
    public void updateUserPw(@PathVariable String userId,@RequestBody UserDTO user){
        userService.updateUserPw(userId,user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
    }
}
