package com.arpinder.userinformation.service;

import com.arpinder.userinformation.dto.UserDTO;
import com.arpinder.userinformation.entity.User;
import com.arpinder.userinformation.mapper.UserMapper;
import com.arpinder.userinformation.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public UserDTO addUser(UserDTO userDTO) {
        System.out.println(userDTO);
        User user = UserMapper.INSTANCE.UserDTOToUser(userDTO);
        userRepo.save(user);
        return UserMapper.INSTANCE.UserToUserDTO(user);
    }

    public ResponseEntity<UserDTO> fetchUserById(Long userId) {
        Optional<User> user = userRepo.findById(userId);
        System.out.println("28---------------------"+user);
        if(user.isPresent()) {
            return new ResponseEntity<>(UserMapper.INSTANCE.UserToUserDTO(user.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
