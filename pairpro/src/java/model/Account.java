/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author 
 */
public class Account implements Serializable{
    private String userId;
    private String pass;
    private int age;
    private String gender;
    
    public Account(String userId,String pass,int age,String gender){
        this.userId=userId;
        this.pass=pass;
        this.age=age;
        this.gender=gender;
    }

    public String getUserId() {
        return userId;
    }

    public String getPass() {
        return pass;
    }

    public int getAge() {
        return age;
    }
    
    public String getGender() {
        return gender;
    }
    
}
