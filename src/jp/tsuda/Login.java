package jp.tsuda;

import javax.jdo.annotations.*;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Login {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String userId;
	 @Persistent
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
