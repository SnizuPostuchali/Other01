package org.test.hw;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException{

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<h1> Hello World </h1>");
        pw.println("</html>");
    }

}
