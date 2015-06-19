/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.GetAccountListLogic;
import model.PostAccountLogic;

/**
 *
 * @author 
 */
@WebServlet(name = "UserRegister", urlPatterns = {"/UserRegister"})
public class UserRegister extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/UserRegister.jsp");
        dispatcher.forward(request, response);
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
        String userID = request.getParameter("userID");
        String pass = request.getParameter("pass");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");

        if ((userID != null && userID.length() != 0)
                && (pass != null && pass.length() != 0)
                && (age != null && age.length() != 0)
                && (gender != null && gender.length() != 0)) {

            HttpSession session = request.getSession();
            String userId = (String) session.getAttribute("userId");//????

            int ageI = Integer.parseInt(age);
            Account account = new Account(userID, pass, ageI, gender);
            //Mutter mutter = new Mutter(userId,text);
            PostAccountLogic postAccountLogic = new PostAccountLogic();
            postAccountLogic.execute(account);

            GetAccountListLogic getAccountListLogic = new GetAccountListLogic();
            List<Account> accountList = getAccountListLogic.execute();
            request.setAttribute("accountList", accountList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("errorMsg", "情報が入力されていません");
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
