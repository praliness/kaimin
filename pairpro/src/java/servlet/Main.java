/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.GetMutterListLogic;
import model.Mutter;
import model.PostMutterLogic;

/**
 *
 * @author 
 */
@WebServlet(name = "Main", urlPatterns = {"/Main"})
public class Main extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
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
    protected void processrequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        String loginUser = (String) session.getAttribute("userId");
        
        /*try {
            // TODO output your page here. You may use following sample code.
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Main</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Main at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
        */
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
        
        GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
        List<Mutter> mutterList = getMutterListLogic.execute();
        request.setAttribute("mutterList", mutterList);
        
        HttpSession session = request.getSession();
        String loginUser = (String)session.getAttribute("userId");
        
        if(loginUser == null){
            response.sendRedirect("/ad4549/");
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
            dispatcher.forward(request,response);
        }
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
      
        request.setCharacterEncoding("UTF-8");
        String text = request.getParameter("text");
        
        if(text != null && text.length() !=0){
            
            HttpSession session = request.getSession();
            String userId =(String) session.getAttribute("userId");
            
            Mutter mutter = new Mutter(userId,text);
            PostMutterLogic postMutterLogic = new PostMutterLogic();
            postMutterLogic.execute(mutter);
            
            GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
            List<Mutter> mutterList = getMutterListLogic.execute();
            request.setAttribute("mutterList", mutterList);
        }else{
            request.setAttribute("errorMsg","つぶやきが入力されていません");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
        dispatcher.forward(request, response);
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
