/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AccountDAO0;

/**
 *
 * @author 
 */
public class LoginLogic {
    public boolean execute(Login login){
        AccountDAO0 dao=new AccountDAO0();
        Account account =dao.findByLogin(login);
        System.out.println(account.getUserId());
        return account != null;
        //return true;
    }
}
