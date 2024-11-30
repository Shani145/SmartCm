package com.SmartCM.SmartCm.services.impl;

import java.util.List;
import java.util.Optional;

import com.SmartCM.SmartCm.helpers.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SmartCM.SmartCm.entities.User;
import com.SmartCM.SmartCm.repsitories.UserRepo;
import com.SmartCM.SmartCm.services.UserService;
import com.SmartCM.SmartCm.helpers.ResourceNotFoundException;
import java.util.UUID;

@Service

public class UserServiceImpl implements UserService {
   @Autowired
   private UserRepo userRepo;
   @Autowired
   private PasswordEncoder passwordEncoder;

   private Logger logger = LoggerFactory.getLogger(this.getClass());






    @Override
    public User saveUser(User user) {
        //user id have to generate
        String  userId = UUID.randomUUID().toString();
        user.setUserId(userId);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //set use  role
        user.setRoleList(List.of(AppConstants.ROLE_USER));
        //password have to generate
        logger.info(user.getProvider().toString());
        
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
       User user2 = userRepo.findById(user.getUserId()).orElseThrow(()->new ResourceNotFoundException("user not found"));
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setProfilePic(user.getProfilePic());
        user2.setEnabled(user.isEnabled());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setPhoneVerified(user.isPhoneVerified());
        user2.setProvider(user.getProvider());
        user2.setProviderUserId(user.getProviderUserId());
        //save the user in the database
        User save = userRepo.save(user2);
        return Optional.ofNullable(save);
    }

    @Override
    public void deleteUser(String id) {
        User user2 = userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("user not found"));
        userRepo.delete(user2);
    }

    @Override
    public boolean isUserExist(String userId) {
        User user2 = userRepo.findById(userId).orElse(null);
        return user2 != null ? true : false;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        User user = userRepo.findById(email).orElse(null);
        return user!= null? true : false;
    }

    @Override
    public List<User> getAllUsers() {
       return userRepo.findAll();
    }

}
