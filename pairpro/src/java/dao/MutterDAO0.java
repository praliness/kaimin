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
import model.Mutter;

/**
 *
 * @author 
 */
public class MutterDAO0 {

    private final String DRIVE_NAME = "org.apache.derby.jdbc.ClientDriver";
    private final String JDBC_URL =
            "jdbc:derby://localhost:1527/db4549";
    private final String DB_USER = "db";
    private final String DB_PASS = "db";

    public List<Mutter> findAll() {
        Connection conn = null;
        List<Mutter> mutterList = new ArrayList<Mutter>();
        try {
            Class.forName(DRIVE_NAME);
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            String sql =
                    "SELECT USER_ID,ITEM,REVIEW FROM MUTTER"; //ORDER BY ID DESC";
            System.out.println(sql);
            PreparedStatement pStmt = conn.prepareStatement(sql);

            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                /*int id = rs.getInt("ID");
                 String userName = rs.getString("NAME");
                 String text = rs.getString("TEXT");
                 Mutter mutter = new Mutter(id, userName, text);*/
                //int age = rs.getInt("AGE");
                String userId = rs.getString("USER_ID");
                String item = rs.getString("ITEM");
                String review=rs.getString("REVIEW");
                Mutter mutter = new Mutter(userId,item,review);
                mutterList.add(mutter);
                //System.out.println(age + ", " + userId + ", " + text);
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
        return mutterList;
    }

    public void create(Mutter mutter) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            String sql = "INSERT INTO MUTTER(USER_ID,ITEM,REVIEW) VALUES(?,?,?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            pStmt.setString(1, mutter.getUserId());
            pStmt.setString(2, ""/*mutter.getItem()*/);
            pStmt.setString(3, mutter.getReview());

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
