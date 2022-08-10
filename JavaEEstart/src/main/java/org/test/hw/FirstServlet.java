package org.test.hw;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException{

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();

        String user = (String)session.getAttribute("current_user");
        if(user == null){
            //ответ для анонимного пользователя
            //авторизация
            //регистрация
            //session.setAttribute("current_user", ID);
        } else {
            //response для авторизованного пользователя
        }

//        Cart cart = (Cart)session.getAttribute("cart");
//        String name = request.getParameter("name");
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//
//        if(cart==null){
//            cart = new Cart();
//            cart.setName(name);
//            cart.setQuantity(quantity);
//        }
//
//        session.setAttribute("cart", cart);


//        Integer count = (Integer)session.getAttribute("cart");
//        if(count==null){
//            session.setAttribute("count", 1);
//            count = 1;
//        } else {
//            session.setAttribute("count", count+1);
//        }

//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
        //       PrintWriter pw = response.getWriter();
//        pw.println("<html>");
//        pw.println("<h1> Your count is: " +  + "</h1>");
//        pw.println("<h1> Hello, " + name  + " " + surname + "</h1>");
//        pw.println("</html>");

//        getServletContext().getRequestDispatcher("/showCart.jsp").forward(request, response);

//        RequestDispatcher dispatcher =request.getRequestDispatcher("/testJsp.jsp");
//        dispatcher.forward(request, response);
    }

}
