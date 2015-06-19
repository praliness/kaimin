/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 
 */
public class Login {
    private String userId;
    private String pass;
    public Login(String userId,String pass){
        this.userId=userId;
        this.pass=pass;
    }

    public String getUserId() {
        return userId;
    }

    public String getPass() {
        return pass;
    }
    
    
}
