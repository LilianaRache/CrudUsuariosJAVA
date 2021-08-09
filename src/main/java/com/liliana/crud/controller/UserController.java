/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.liliana.crud.controller;

import com.liliana.crud.entity.UsersEntity;
import com.liliana.crud.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
public class UserController {
 
    @Autowired
    UserService userService;
 
    @RequestMapping(value = "/users")
    public ResponseEntity<List<UsersEntity>> getAll() {
        return new ResponseEntity(userService.getAll(), HttpStatus.OK);
    }
    
    @PostMapping(value = "/user")
    public ResponseEntity<UsersEntity> save(@Valid @RequestBody UsersEntity user){
        return new ResponseEntity(userService.save(user), HttpStatus.CREATED);
    }
    
    @PutMapping(value = "/user/{username}")
    public void updatePassByUserName(@RequestBody String pass, @PathVariable String userName){
        userService.updatePassByUserName(pass, userName);
    }
    
    @DeleteMapping(value = "/user/{username}")
    public void deleteUser(@PathVariable String username){
        userService.deleteUser(username);
    }
    
    @PostMapping(value = "/user/validate")
    public ResponseEntity<Boolean> validateUser(@RequestBody String username, @RequestBody String password){
        return new ResponseEntity(userService.findUserByUserNameAndPass(username, password), HttpStatus.OK);
    }
}