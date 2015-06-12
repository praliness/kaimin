/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.tsuda;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Login;
import model.LoginLogic;
import java.io.*;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.http.*;
/**
 *
 * @author 
 */
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
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
                res += "{id:" + data.getUserId() + ",pass:'" + data.getPass() +"'},";
            }
        }
        res += "]";
        out.println(res);
        manager.close();
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        request.setCharacterEncoding("UTF-8");
        String userId = request.getParameter("userID");
        String pass = request.getParameter("pass");
        
        Login login = new Login(userId, pass);
        LoginLogic bo = new LoginLogic();
        boolean result = bo.execute(login);
        
        if (result) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "/WEB-INF/jsp/loginOK.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("/ad4549/LoginServlet");
            System.out.println(userId);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
