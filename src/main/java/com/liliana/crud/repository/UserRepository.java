/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.liliana.crud.repository;

import com.liliana.crud.entity.UsersEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public interface UserRepository extends CrudRepository<UsersEntity, Long> {
 
    @Query("FROM UsersEntity")
    public List<UsersEntity> getAll();
    
    public UsersEntity save(UsersEntity user);
    
    @Modifying
    @Query("update Users u set u.pass = ?1 where u.username = ?2")
    void updatePassByUserName(String pass, String username);
    
    @Modifying
    @Query("delete from Users b where b.username=:username")
    void deleteUser(@Param("username") String username);
    
    @Query("SELECT u FROM Users u WHERE u.username = ?1 and u.pass = ?2")
    UsersEntity findUserByUserNameAndPass(String username, String pass);
}
