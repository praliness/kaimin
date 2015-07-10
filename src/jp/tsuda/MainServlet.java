package jp.tsuda;

import java.io.*;


import java.util.*;

import javax.jdo.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class MainServlet extends HttpServlet {
   public void doGet(HttpServletRequest req,
           HttpServletResponse resp)
           throws IOException {
       PersistenceManagerFactory factory = PMF.get();
       PersistenceManager manager = factory.getPersistenceManager();
       resp.setCharacterEncoding("UTF-8");
       resp.setContentType("text/html");
       req.setCharacterEncoding("utf-8");
       String param1 = req.getParameter("id");
       PrintWriter out = resp.getWriter();
       List<Login> list = null;
       if (param1 == null || param1 ==""){
           String query = "select from " + Login.class.getName();
           try {
               list = (List<Login>)manager.newQuery(query).execute();
           } catch(JDOObjectNotFoundException e){}
       } else {
           try {
        	   Login data = (Login)manager.getObjectById(Login.class,Long.parseLong(param1));
               list = new ArrayList();
               list.add(data);
           } catch(JDOObjectNotFoundException e){}
       }
       String res = "[";
       if (list != null){
           for(Login data:list){
               res += "{id:" + data.getId()  + "',title:'" +
                   data.getTitle() +
                   "',comment:'" + data.getComment() + "'},";
           }
       }
       res += "]";
       out.println(res);
       manager.close();
   }
}