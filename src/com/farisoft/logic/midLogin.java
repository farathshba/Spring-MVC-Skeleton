
package com.farisoft.logic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Farath
 */
public class midLogin 
{
    private final String username;
    private final String password;
    
    public midLogin(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    
    public boolean checkLoginCred()
    {
        
        return true;
    }
    
    public String hash(String password) 
    {
        try 
        {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            String salt = "some_random_salt";
            String passWithSalt = password + salt;
            byte[] passBytes = passWithSalt.getBytes();
            byte[] passHash = sha256.digest(passBytes);             
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< passHash.length ;i++) 
            {
                sb.append(Integer.toString((passHash[i] & 0xff) + 0x100, 16).substring(1));         
            }
            String generatedPassword = sb.toString();
            return generatedPassword;
        } 
        catch (NoSuchAlgorithmException e) 
        { 
            e.printStackTrace(); 
        }       
        return null;
    }
}
