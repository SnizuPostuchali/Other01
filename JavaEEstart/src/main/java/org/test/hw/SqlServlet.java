package org.test.hw;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class SqlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter pw = response.getWriter();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jap_dic", "dictionary", "dictionary")) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from dictionary");

            while (rs.next()){
                pw.println(rs.getString("2"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}