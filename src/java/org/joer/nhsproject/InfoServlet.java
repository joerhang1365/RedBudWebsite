package org.joer.nhsproject;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class InfoServlet implements Servlet
{
    private ServletConfig config;
    private String[] validNames;
    private String buildingName;
    
    public InfoServlet()
    {
        validNames = new String[7];
        validNames[0] = "ziebold building";
        validNames[1] = "rathert's clothing store";
        validNames[2] = "ratherts clothing store";
        validNames[3] = "kaftenbergan building";
        validNames[4] = "opera house";
        validNames[5] = "city hall";
        validNames[6] = "destroy computer";
        
        buildingName = "";
    }
    
    public boolean isValidName()
    {
        boolean result = false;
        for(int i = 0; i < validNames.length; i++)
            if(buildingName.equals(validNames[i]))
                result = true;
        return result;
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException
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
        String webpage = "";  
        buildingName = request.getParameter("buildingName").toLowerCase();
        
        if(isValidName())
            switch(buildingName)
            {
                case "ziebold building": webpage = "/ziebold.jsp"; break;
                case "rathert's clothing store":
                case "ratherts clothing store": webpage = "/rathert.jsp"; break;
                case "kaftenbergan building": webpage = "/kaftenbergan.jsp"; break;
                case "opera house": webpage = "/opera.jsp"; break;
                case "destroy computer": webpage = "/destroy.jsp"; break;
                default: webpage = "cityhall.jsp";
            }
        else
            webpage = "/error.jsp";
        
        request.getRequestDispatcher(webpage).forward(request, response);
    }

    @Override
    public String getServletInfo()
    {
        return "InfoServlet";
    }

    @Override
    public void destroy()
    {
        System.out.println("Clean here...");
    }
}
