package com.mcb.abdulbasit.valuation.service;

import com.mcb.abdulbasit.valuation.enums.Role;
import com.mcb.abdulbasit.valuation.model.User;
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
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * getUser
     * @param id
     * @return
     */
    public User getUser(Integer id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            // return no user custom error msg
        }
        return user.get();
    }

    public User getUserByUsername(String username){
        Optional<User> user = userRepository.findByUsername(username);
        if(!user.isPresent()){
            // return no user custom error msg
        }
        return user.get();
    }

    public UserDetailsService userDetailsService() {
        return username -> {
            User user = getUserByUsername(username);
            if (!username.equals(user.getUsername())) throw new UsernameNotFoundException("User not found");

            return new User(username, user.getPassword());
        };
    }

    public User save(){
        // encrypt user password
        String encryptedPwd = bCryptPasswordEncoder.encode("admin");
        User user = new User();
        user.setUsername("admin");
        user.setFullname("John Doe");
        user.setBusinessUnit("Ebene BU - RB000235");
        user.setContactNumber("9034 8721");
        user.setPassword(encryptedPwd);
        return userRepository.save(user);
    }

}
