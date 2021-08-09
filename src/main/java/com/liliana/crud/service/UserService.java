/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.liliana.crud.service;

import com.liliana.crud.entity.UsersEntity;
import com.liliana.crud.repository.UserRepository;
import com.liliana.crud.utils.Utilities;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class UserService {
 
    @Autowired
    UserRepository userRepository;
 
    public List<UsersEntity> getAll() {
        
        List<UsersEntity> encodedUsers = userRepository.getAll();
        List<UsersEntity> responseList = new ArrayList<>();
        
        for (UsersEntity encodedUser : encodedUsers) {
            
            String passDecode = Utilities.decodePassword(encodedUser.getPass());
            encodedUser.setPass(passDecode);
            
            responseList.add(encodedUser);
        }        
        
        return responseList;
    }
    
    public UsersEntity save(UsersEntity user){
        
        String encodedPass = Utilities.encodePassword(user.getPass());
        user.setPass(encodedPass);
        
        return userRepository.save(user);
    }
    
    public void updatePassByUserName(String pass, String userName){
        String encodedPass = Utilities.encodePassword(pass);
        userRepository.updatePassByUserName(encodedPass, userName);
    }
    
    public void deleteUser(String username){
        userRepository.deleteUser(username);
    }
    
    public boolean findUserByUserNameAndPass(String username, String pass){
        String encodedPass = Utilities.encodePassword(pass);
        return userRepository.findUserByUserNameAndPass(username, encodedPass) != null;
    }
}
