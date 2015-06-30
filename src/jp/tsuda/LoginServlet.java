/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.tsuda;

import java.io.*;
import java.util.*;

import javax.jdo.*;
import javax.servlet.http.*;


@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

    
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws IOException {
    	PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        String param1 = req.getParameter("id");
        PrintWriter out = resp.getWriter();
        List<Account> list = null;
        if (param1 == null || param1 ==""){
            String query = "select from " + Account.class.getName();
            try {
                list = (List<Account>)manager.newQuery(query).execute();
            } catch(JDOObjectNotFoundException e){}
        } else {
            try {
                Account data = (Account)manager.getObjectById(Account.class,Long.parseLong(param1));
                list = new ArrayList();
                list.add(data);
            } catch(JDOObjectNotFoundException e){}
        }
        String res = "[";
        if (list != null){
            for(Account data:list){
                res += "{id:" + data.getUserId() + ",pass:'" + data.getPass() + "'},";
            }
        }
        res += "]";
        out.println(res);
        manager.close();
    }
}