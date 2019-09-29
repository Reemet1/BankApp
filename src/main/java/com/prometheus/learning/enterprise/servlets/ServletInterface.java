package com.prometheus.learning.enterprise.servlets;

import javax.servlet.*;
import java.io.IOException;

public class ServletInterface implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // Called by the servlet container to indicate to a servlet that the servlet is being placed into service.
    }

    @Override
    public ServletConfig getServletConfig() {
        // Returns a ServletConfig object, which contains initialization and startup parameters for this servlet.
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // Called by the servlet container to allow the servlet to respond to a request.
    }

    @Override
    public String getServletInfo() {
        // Returns information about the servlet, such as author, version, and copyright.
        return null;
    }

    @Override
    public void destroy() {
        // Called by the servlet container to indicate to a servlet that the servlet is being taken out of service.
    }
}
