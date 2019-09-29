package com.prometheus.learning.enterprise.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookiesEx")
public class CookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie1 = new Cookie("eesnimi", "Reemet");
        Cookie cookie2 = new Cookie("perenimi","Ammer");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        resp.addCookie(cookie1);
        resp.addCookie(cookie2);

        Cookie[] cookies = req.getCookies();

        for(Cookie cookie : cookies) {
            out.println(cookie.getName() + " - " + cookie.getValue());
            out.println("</br>");
        }

        /** Deleting cookie */
        //cookie1.setMaxAge(0);

        /** java.lang.Object	clone() */
        // Overrides the standard java.lang.Object.clone method to return a copy of this cookie.

        /** java.lang.String	getComment() */
        // Returns the comment describing the purpose of this cookie, or null if the cookie has no comment.

        /** java.lang.String	getDomain() */
        // Returns the domain name set for this cookie.

        /** int	getMaxAge() */
        /* Returns the maximum age of the cookie, specified in seconds,
        By default, -1 indicating the cookie will persist until browser shutdown. */

        /** java.lang.String	getName() */
        // Returns the name of the cookie.

        /** java.lang.String	getPath() */
        // Returns the path on the server to which the browser returns this cookie.

        /** boolean	getSecure() */
        /* Returns true if the browser is sending cookies only over a secure protocol,
        or false if the browser can send cookies using any protocol. */

        /** java.lang.String	getValue() */
        // Returns the value of the cookie.

        /** int	getVersion() */
        // Returns the version of the protocol this cookie complies with.

        /** void	setComment(java.lang.String purpose) */
        // Specifies a comment that describes a cookie's purpose.

        /** void	setDomain(java.lang.String pattern) */
        // Specifies the domain within which this cookie should be presented.

        /** void	setMaxAge(int expiry) */
        // Sets the maximum age of the cookie in seconds.

        /** void	setPath(java.lang.String uri) */
        // Specifies a path for the cookie to which the client should return the cookie.

        /** void	setSecure(boolean flag) */
        /* Indicates to the browser whether the cookie should only be sent using a secure protocol,
           such as HTTPS or SSL. */

        /** void	setValue(java.lang.String newValue) */
        // Assigns a new value to a cookie after the cookie is created.

        /** void	setVersion(int v) */
        // Sets the version of the cookie protocol this cookie complies with.

    }
}
