package jp.tsuda;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;




@SuppressWarnings("serial")
public class WelcomeServlet extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("please wait...");
    }
 
    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        resp.sendRedirect("/welcome.html");
    }
}