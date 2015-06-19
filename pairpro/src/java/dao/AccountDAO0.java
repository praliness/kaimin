/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Login;

/**
 *
 * @author
 */
public class AccountDAO0 {

    private final String DRIVE_NAME = "org.apache.derby.jdbc.ClientDriver";
    private final String JDBC_URL =
            "jdbc:derby://localhost:1527/db4549";
    private final String DB_USER = "db";
    private final String DB_PASS = "db";

    public Account findByLogin(Login login) {
        Connection conn = null;
        Account account = null;
        //List<Account> accountList = new ArrayList<Account>();
        try {
            System.out.println("test");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/db4549", "db", "db");//here

            String sql = "SELECT USER_ID,PASS,AGE,GENDER "
                    + "FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, login.getUserId());
            pStmt.setString(2, login.getPass());

            ResultSet rs = pStmt.executeQuery();
            System.out.println(login.getUserId());

            if (rs.next()) {
                String userId = rs.getString("USER_ID");
                String pass = rs.getString("PASS");
                int age = rs.getInt("AGE");
                String gender = rs.getString("GENDER");

                account = new Account(userId, pass, age, gender);
                //accountList.add(account);
                System.err.println("account is found");
            }
            System.err.println("account is not found");
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println(e);
            //return null;
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            System.out.println(e);
            //return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    //e.printStackTrace();
                    System.out.println(e);
                    //return null;
                }
            }
            // return account;
        }
        if (account
                == null) {
            System.out.println("account is null");
        } else {
            System.out.println("account is minato");
        }
        //System.out.println(account.getUserId());
        return account;
    }

    public List<Account> findAll() {
        Connection conn = null;
        Account account = null;
        List<Account> accountList = new ArrayList<Account>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(
                    JDBC_URL, DB_USER, DB_PASS);
            String sq1 =
                    "SELECT NAME,PASS FROM DATA ORDER BY ID DESC";
            PreparedStatement pStmt = conn.prepareStatement(sq1);

            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {

                String userId = rs.getString("USER_ID");
                String pass = rs.getString("PASS");
                int age = rs.getInt("AGE");
                String gender = rs.getString("GENDER");

                account = new Account(userId, pass, age, gender);
                //accountList.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return accountList;
    }

    public void create(Account account) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            String sql = "INSERT INTO ACCOUNT(USER_ID,PASS,AGE,GENDER) VALUES(?,?,?,?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            pStmt.setString(1, account.getUserId());
            pStmt.setString(2, account.getPass());
            pStmt.setInt(3, account.getAge());
            pStmt.setString(4, account.getGender());

            int result = pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
