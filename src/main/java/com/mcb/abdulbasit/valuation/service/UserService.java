package com.mcb.abdulbasit.valuation.service;

import com.mcb.abdulbasit.valuation.model.User;
import com.mcb.abdulbasit.valuation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(Long id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            // return no user custom error msg
        }
        return user.get();
    }
}
