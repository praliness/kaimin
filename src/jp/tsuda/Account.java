package jp.tsuda;

import javax.jdo.annotations.*;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Account{
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String userId;
    
    @Persistent
    private String pass;
    
    @Persistent
    private int age;
    
    @Persistent
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

