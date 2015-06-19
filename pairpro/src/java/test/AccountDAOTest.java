/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.AccountDAO0;
import model.Account;
import model.Login;

/**
 *
 * @author 
 */
public class AccountDAOTest {

    public static void main(String[] args) {
        testFindByLogin1();
        testFindByLogin2();
    }

    public static void testFindByLogin1() {
        Login login = new Login("minato", "1234");
        AccountDAO0 dao = new AccountDAO0();
        Account result = dao.findByLogin(login);
        if (result != null
                && //result.getUserId().equals("minato") &&
                result.getPass().equals("1234")
                //&& result.getMail().equals("minato@sukkiri.com")
                //&& result.getName().equals("湊 雄輔")
                && result.getAge() == 23) {
            System.out.println("1:成功");
        } else {
            System.out.println("false1");
        }
    }

    public static void testFindByLogin2() {
        Login login = new Login("minato", "12345");
        AccountDAO0 dao = new AccountDAO0();
        Account result = dao.findByLogin(login);
        if (result == null) {
            System.out.println("2:成功");
        } else {
            System.out.println("false2");
        }
    }
}
