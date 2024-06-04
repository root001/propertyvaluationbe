package com.mcb.abdulbasit.valuation.service;

import com.mcb.abdulbasit.valuation.model.Users;
import com.mcb.abdulbasit.valuation.repository.UserRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * getAllUsers
     * @return
     */
    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * getUser
     * @param id
     * @return
     */
    public Users getUser(Integer id){
        if(id < 0)
            throw new IllegalArgumentException("user id cannot be null or empty.");
        Optional<Users> user = userRepository.findById(id);
        if(!user.isPresent()){
            // return no user custom error msg
            throw new UsernameNotFoundException("Users not found");
        }
        return user.get();
    }

    public Users getUserByUsername(String username){
        if(StringUtils.isEmpty(username))
            throw new IllegalArgumentException("username cannot be null or empty.");
        Optional<Users> user = userRepository.findByUsername(username);
        if(!user.isPresent()){
            // return no user custom error msg
            throw new UsernameNotFoundException("Users not found");
        }
        return user.get();
    }

    public UserDetailsService userDetailsService() {
        return username -> {
            Users user = getUserByUsername(username);
            if (!username.equals(user.getUsername())) throw new UsernameNotFoundException("Users not found");

            return new Users(username, user.getPassword());
        };
    }

}
