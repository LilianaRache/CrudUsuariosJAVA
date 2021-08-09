/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.liliana.crud.utils;

import java.util.Base64;

/**
 *
 * @author Usuario
 */
public class Utilities {
    
    public static String encodePassword(String password){
        return Base64.getEncoder().encodeToString(password.getBytes());
    }
    
    public static String decodePassword(String passwordEncoded){
        byte[] decodedBytes = Base64.getDecoder().decode(passwordEncoded);
        return new String(decodedBytes);
    }
}
