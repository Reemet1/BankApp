package com.prometheus.learning.enterprise.servlets;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Servlet ExampleFilter are Java classes that can be used in Servlet Programming for the following purposes −
 *
 * To intercept requests from a client before they access a resource at back end.
 *
 * To manipulate responses from server before they are sent back to the client.
 *
 * There are various types of filters suggested by the specifications −
 *
 * Authentication ExampleFilter.
 * Data compression ExampleFilter.
 * Encryption ExampleFilter.
 * ExampleFilter that trigger resource access events.
 * Image Conversion ExampleFilter.
 * Logging and Auditing ExampleFilter.
 * MIME-TYPE Chain ExampleFilter.
 * Tokenizing ExampleFilter .
 * XSL/T ExampleFilter That Transform XML Content.
 *
 * Filters are deployed in the deployment descriptor file web.xml and then map to either
 * servlet names or URL patterns in your application's deployment descriptor.
 *
 * <filter>
 *    <filter-name>ExampleFilter</filter-name>
 *    <filter-class>ExampleFilter</filter-class>
 *    <init-param>
 *       <param-name>test-param</param-name>
 *       <param-value>Initialization Paramter</param-value>
 *    </init-param>
 * </filter>
 *
 * <filter-mapping>
 *    <filter-name>LogFilter</filter-name>
 *    <url-pattern>/*</url-pattern>
 * </filter-mapping>
 */

public class ExampleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

            // Get the IP address of client machine.
            String ipAddress = servletRequest.getRemoteAddr();

            // Log the IP address and current timestamp.
            System.out.println("IP "+ ipAddress + ", Time " + new Date().toString());

            // Pass request back down the filter chain
            filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
