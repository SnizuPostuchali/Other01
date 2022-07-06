package org.test.hw;

import javax.servlet.http.*;
import java.io.IOException;

public class Hello extends HttpServlet {
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
                throws IOException
    {
        httpServletResponse.getWriter().print("Test servlet");
    }

}
