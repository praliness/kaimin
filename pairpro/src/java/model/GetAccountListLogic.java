/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AccountDAO0;
import java.util.List;

/**
 *
 * @author 
 */
public class GetAccountListLogic {
    public List<Account> execute() {
        AccountDAO0 dao = new AccountDAO0();
        List<Account> accountList = dao.findAll();
        return accountList;
    }
}
