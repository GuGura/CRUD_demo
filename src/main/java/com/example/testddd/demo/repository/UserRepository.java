package com.example.testddd.demo.repository;


import com.example.testddd.demo.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    // db 연동하는 코드
    // JPA
    static public ArrayList<UserDTO> users;

    static {
        users = new ArrayList<>();
        users.add(new UserDTO("kang","test1","1234"));
        users.add(new UserDTO("park","test2","1234"));
        users.add(new UserDTO("kim","test3","1234"));
    }

    public UserDTO insertUser(UserDTO user){
        users.add(user);
        return user;
    }

    public List<UserDTO> getAllUsers(){
        return users;
    }

    public UserDTO getUserByUserId(String userId){
        return users.stream()
                .filter(userDTO -> userDTO.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDTO("","",""));
    }

    public void updateUserPw(String userId, UserDTO user){
        users.stream()
                .filter(userDTO -> userDTO.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDTO("","",""))
                .setUserPw(user.getUserPw());
    }

    public void deleteUser(String userId){
        users.removeIf(userDTO -> userDTO.getUserId().equals(userId));
    }
}
