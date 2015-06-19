/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author 
 */
public class Mutter implements Serializable {
    //private int age;
    private String userId;
    private String item;
    private String review;
    public Mutter(){}
    public Mutter(String userId,String item,String review){
        this.userId=userId;
        this.item=item;
        this.review=review;
    }
    
    public Mutter(String userId,String review){
        //this.age=age;
        this.userId=userId;
        this.review=review;
    }

    /*public int getAge() {
        return age;
    }*/
    
    public String getUserId() {
        return userId;
    }

    public String getItem() {
        return item;
    }

    public String getReview() {
        return review;
    }
    
}
