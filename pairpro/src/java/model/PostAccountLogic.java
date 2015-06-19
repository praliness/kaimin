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
public class PostAccountLogic {
    public void execute(Account account/*,List<Mutter> mutterList*/){
        //mutterList.add(0,mutter);
        AccountDAO0 dao=new AccountDAO0();
        dao.create(account);
    }
}
