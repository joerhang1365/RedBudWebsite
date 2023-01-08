
package org.joer.nhsproject;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

public class DestroyServlet implements Servlet
{
    private ServletConfig config;
    
    @Override
    public void init(ServletConfig sc) throws ServletException
    {
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig()
    {
        return config;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        boolean loop = true;
        BigInteger num = new BigInteger("2");
        int i = 1;
        
        out.println("<style>");
        out.println("body {word-wrap: break-word;}");
        out.println("</style>");
        
        out.println("<body>");
        
        while(loop)
        {
            num = num.multiply(new BigInteger("" + i));
            i++;
            out.print(num);
        }
        
        out.println("</body>");
        out.close();
    }

    @Override
    public String getServletInfo()
    {
        return "DestroyServlet";
    }

    @Override
    public void destroy()
    {
        System.out.println("Clean here...");
    }
}
