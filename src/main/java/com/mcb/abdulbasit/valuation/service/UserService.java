package com.mcb.abdulbasit.valuation.service;

import com.mcb.abdulbasit.valuation.enums.Role;
import com.mcb.abdulbasit.valuation.model.Users;
import com.mcb.abdulbasit.valuation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

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
        Optional<Users> user = userRepository.findById(id);
        if(!user.isPresent()){
            // return no user custom error msg
        }
        return user.get();
    }

    public Users getUserByUsername(String username){
        Optional<Users> user = userRepository.findByUsername(username);
        if(!user.isPresent()){
            // return no user custom error msg
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
