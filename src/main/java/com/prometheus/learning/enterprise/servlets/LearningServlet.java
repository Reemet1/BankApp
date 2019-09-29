package com.prometheus.learning.enterprise.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/** A servlet is a Java class that handles HTTP requests from the browser, does the necessary
 *  calculations using application code and then returns the result to the browser.
 *  Servlets sit between client and application, and form the Controller part of MVC architecture.
 */

@WebServlet("/LearningServlet")
public class LearningServlet extends HttpServlet {

    @Override
    /** A convenience method which can be overridden so that there's no need to call super.init(config) */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    /** Called by the servlet container to indicate to a servlet that the servlet is being placed into service */
    public void init() throws ServletException {
        super.init();
    }

    @Override
    /** Receives standard HTTP requests from the public service method and dispatches them
        to the doXXX methods defined in this class */
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        resp.sendError(404, "Content not found");
    }

    @Override
    /** Called by the server (via the service method) to allow a servlet to handle a GET request */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Enumeration<String> headers = req.getHeaderNames();
        while(headers.hasMoreElements()) {
            String header = headers.nextElement();
            out.println(headers.nextElement() + ": " + req.getHeader(header));
            out.println("</br>");
        }
    }

    @Override
    /** Receives an HTTP HEAD request from the protected service method and handles the request */
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);
    }

    @Override
    /** Called by the server (via the service method) to allow a servlet to handle a POST request */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    /** Called by the server (via the service method) to allow a servlet to handle a PUT request */
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    /** Called by the server (via the service method) to allow a servlet to handle a DELETE request */
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    /** Called by the server (via the service method) to allow a servlet to handle a OPTIONS request */
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doOptions(req, resp);
    }

    @Override
    /** Called by the server (via the service method) to allow a servlet to handle a TRACE request */
    protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doTrace(req, resp);
    }

    @Override
    /** Called by the server (via the service method) to allow a servlet to handle a TRACE request */
    public void destroy() {
        super.destroy();
        /* The destroy() method is called only once at the end of the life cycle of a servlet.
         * This method gives your servlet a chance to close database connections, halt background threads,
         * write cookie lists or hit counts to disk, and perform other such cleanup activities.
         * After the destroy() method is called, the servlet object is marked for garbage collection.
         */
    }


    /** Methods inherited from GenericServlet and HttpServlet class */
    public void servletMethods() {

        /** Methods inherited from GenericServlet class */

        /** void	destroy() */
        // Called by the servlet container to indicate to a servlet that the servlet is being taken out of service.

        /** java.lang.String	getInitParameter(java.lang.String name) */
        /* Returns a String containing the value of the named initialization parameter,
           or null if the parameter does not exist. */
        String initParameter = getInitParameter("initParameter");

        /** java.util.Enumeration	getInitParameterNames() */
        /* Returns the names of the servlet's initialization parameters as an Enumeration of String objects,
           or an empty Enumeration if the servlet has no initialization parameters. */

        /** ServletConfig	getServletConfig() */
        // Returns this servlet's ServletConfig object.

        /** ServletContext	getServletContext() */
        // Returns a reference to the ServletContext in which this servlet is running.

        /** java.lang.String	getServletInfo() */
        // Returns information about the servlet, such as author, version, and copyright.

        /** java.lang.String	getServletName() */
        // Returns the name of this servlet instance.

        /** void	init() */
        // A convenience method which can be overridden so that there's no need to call super.init(config).

        /** void	init(ServletConfig config) */
        // Called by the servlet container to indicate to a servlet that the servlet is being placed into service.

        /** void	log(java.lang.String msg) */
        // Writes the specified message to a servlet log file, prepended by the servlet's name.

        /** void	log(java.lang.String message, java.lang.Throwable t) */
        /* Writes an explanatory message and a stack trace for a given Throwable exception to the servlet log file,
           prepended by the servlet's name. */

        /** abstract  void	service(ServletRequest req, ServletResponse res) */
        // Called by the servlet container to allow the servlet to respond to a request.


        /** Methods inherited from HttpServlet class */

        /** protected long	getLastModified(HttpServletRequest req) */
        /* Returns the time the HttpServletRequest object was last modified,
           in milliseconds since midnight January 1, 1970 GMT. */

    }







    /** METHODS INHERITED FROM HttpServlet CLASS */



    public void servletRequest() {

        ServletRequest servletRequest;

        /** AsyncContext	getAsyncContext() */
        /* Gets the AsyncContext that was created or reinitialized by the most recent invocation
           of startAsync() or startAsync(ServletRequest,ServletResponse) on this request. */

        /** java.lang.Object	getAttribute(java.lang.String name) */
        // Returns the value of the named attribute as an Object, or null if no attribute of the given name exists.

        /** java.util.Enumeration<java.lang.String>	getAttributeNames() */
        // Returns an Enumeration containing the names of the attributes available to this request.

        /** java.lang.String	getCharacterEncoding() */
        // Returns the name of the character encoding used in the body of this request.

        /** int	getContentLength() */
        /* Returns the length, in bytes, of the request body and made available by the input stream,
           or -1 if the length is not known. */

        /** java.lang.String	getContentType() */
        // Returns the MIME type of the body of the request, or null if the type is not known.

        /** DispatcherType	getDispatcherType() */
        // Gets the dispatcher type of this request.

        /** ServletInputStream	getInputStream() */
        // Retrieves the body of the request as binary data using a ServletInputStream.

        /** java.lang.String	getLocalAddr() */
        // Returns the Internet Protocol (IP) address of the interface on which the request was received.

        /** java.util.Locale	getLocale() */
        /* Returns the preferred Locale that the client will accept content in, based on
           the Accept-Language header. */

        /** java.util.Enumeration<java.util.Locale>	getLocales() */
        /* Returns an Enumeration of Locale objects indicating, in decreasing order starting with the
           preferred locale, the locales that are acceptable to the client based on the Accept-Language header. */

        /** java.lang.String	getLocalName() */
        // Returns the host name of the Internet Protocol (IP) interface on which the request was received.

        /** int	getLocalPort() */
        // Returns the Internet Protocol (IP) port number of the interface on which the request was received.

        /** java.lang.String	getParameter(java.lang.String name) */
        // Returns the value of a request parameter as a String, or null if the parameter does not exist.

        /** java.util.Map<java.lang.String,java.lang.String[]>	getParameterMap() */
        // Returns a java.util.Map of the parameters of this request.

        /** java.util.Enumeration<java.lang.String>	getParameterNames() */
        /* Returns an Enumeration of String objects containing the names of the parameters
           contained in this request. */

        /** java.lang.String[]	getParameterValues(java.lang.String name) */
        /* Returns an array of String objects containing all of the values the given request parameter has,
           or null if the parameter does not exist. */

        /** java.lang.String	getProtocol() */
        /* Returns the name and version of the protocol the request uses in the form
           protocol/majorVersion.minorVersion, for example, HTTP/1.1. */

        /** java.io.BufferedReader	getReader() */
        // Retrieves the body of the request as character data using a BufferedReader.

        /** java.lang.String	getRemoteAddr() */
        // Returns the Internet Protocol (IP) address of the client or last proxy that sent the request.

        /** java.lang.String	getRemoteHost() */
        // Returns the fully qualified name of the client or the last proxy that sent the request.

        /** int	getRemotePort() */
        // Returns the Internet Protocol (IP) source port of the client or last proxy that sent the request.

        /** RequestDispatcher	getRequestDispatcher(java.lang.String path) */
        // Returns a RequestDispatcher object that acts as a wrapper for the resource located at the given path.

        /** java.lang.String	getScheme() */
        // Returns the name of the scheme used to make this request, for example, http, https, or ftp.

        /** java.lang.String	getServerName() */
        // Returns the host name of the server to which the request was sent.

        /** int	getServerPort() */
        // Returns the port number to which the request was sent.

        /** ServletContext	getServletContext() */
        // Gets the servlet context to which this ServletRequest was last dispatched.

        /** boolean	isAsyncStarted() */
        // Checks if this request has been put into asynchronous mode.

        /** boolean	isAsyncSupported() */
        // Checks if this request supports asynchronous operation.

        /** boolean	isSecure() */
        // Returns a boolean indicating whether this request was made using a secure channel, such as HTTPS.

        /** void	removeAttribute(java.lang.String name) */
        // Removes an attribute from this request.

        /** void	setAttribute(java.lang.String name, java.lang.Object o) */
        // Stores an attribute in this request.

        /** void	setCharacterEncoding(java.lang.String env) */
        // Overrides the name of the character encoding used in the body of this request.

        /** AsyncContext	startAsync() */
        /* Puts this request into asynchronous mode, and initializes its AsyncContext with
           the original (unwrapped) ServletRequest and ServletResponse objects. */

        /** AsyncContext	startAsync(ServletRequest servletRequest, ServletResponse servletResponse) */
        /* Puts this request into asynchronous mode, and initializes its AsyncContext with the
           given request and response objects. */
    }

    public void httpServletRequest() {

        HttpServletRequest httpServletRequest;

        String basicAuth = HttpServletRequest.BASIC_AUTH; //identifier for Basic authentication.
        String clientCertAuth = HttpServletRequest.CLIENT_CERT_AUTH; //identifier for Client Certificate authentication.
        String digestAuth = HttpServletRequest.DIGEST_AUTH; //identifier for Digest authentication.
        String formAuth = HttpServletRequest.FORM_AUTH; //identifier for Form authentication.

        /** boolean	authenticate(HttpServletResponse response) */
        /* Use the container login mechanism configured for the ServletContext to authenticate the
           user making this request. */

        /** java.lang.String	getAuthType() */
        // Returns the name of the authentication scheme used to protect the servlet.

        /** java.lang.String	getContextPath() */
        // Returns the portion of the request URI that indicates the context of the request.

        /** Cookie[]	getCookies() */
        // Returns an array containing all of the Cookie objects the client sent with this request.

        /** long	getDateHeader(java.lang.String name) */
        // Returns the value of the specified request header as a long value that represents a Date object.

        /** java.lang.String	getHeader(java.lang.String name) */
        // Returns the value of the specified request header as a String.

        /** java.util.Enumeration<java.lang.String>	getHeaderNames() */
        // Returns an enumeration of all the header names this request contains.

        /** java.util.Enumeration<java.lang.String>	getHeaders(java.lang.String name) */
        // Returns all the values of the specified request header as an Enumeration of String objects.

        /** int	getIntHeader(java.lang.String name) */
        // Returns the value of the specified request header as an int.

        /** java.lang.String	getMethod() */
        // Returns the name of the HTTP method with which this request was made, for example, GET, POST, or PUT.

        /** Part	getPart(java.lang.String name) */
        // Gets the Part with the given name.

        /** java.util.Collection<Part>	getParts() */
        // Gets all the Part components of this request, provided that it is of type multipart/form-data.

        /** java.lang.String	getPathInfo() */
        // Returns any extra path information associated with the URL the client sent when it made this request.

        /** java.lang.String	getPathTranslated() */
        /* Returns any extra path information after the servlet name but before the query string,
           and translates it to a real path. */

        /** java.lang.String	getQueryString() */
        // Returns the query string that is contained in the request URL after the path.

        /** java.lang.String	getRemoteUser() */
        /* Returns the login of the user making this request, if the user has been authenticated,
           or null if the user has not been authenticated. */

        /** java.lang.String	getRequestedSessionId() */
        // Returns the session ID specified by the client.

        /** java.lang.String	getRequestURI() */
        /* Returns the part of this request's URL from the protocol name up to the query string
           in the first line of the HTTP request. */

        /** java.lang.StringBuffer	getRequestURL() */
        // Reconstructs the URL the client used to make the request.

        /** java.lang.String	getServletPath() */
        // Returns the part of this request's URL that calls the servlet.

        /** HttpSession	getSession() */
        /* Returns the current session associated with this request, or if the request does
           not have a session, creates one. */

        /** HttpSession	getSession(boolean create) */
        /* Returns the current HttpSession associated with this request or,
           if there is no current session and create is true, returns a new session. */

        /** java.security.Principal	getUserPrincipal() */
        // Returns a java.security.Principal object containing the name of the current authenticated user.

        /** boolean	isRequestedSessionIdFromCookie() */
        // Checks whether the requested session ID came in as a cookie.

        /** boolean	isRequestedSessionIdFromURL() */
        // Checks whether the requested session ID came in as part of the request URL.

        /** boolean	isRequestedSessionIdValid() */
        // Checks whether the requested session ID is still valid.

        /** boolean	isUserInRole(java.lang.String role) */
        // Returns a boolean indicating whether the authenticated user is included in the specified logical "role".

        /** void	login(java.lang.String username, java.lang.String password) */
        /* Validate the provided username and password in the password validation realm used by the
           web container login mechanism configured for the ServletContext. */

        /** void	logout() */
        /* Establish null as the value returned when getUserPrincipal, getRemoteUser,
           and getAuthType is called on the request. */

    }

    public void servletResponse() {

        ServletResponse servletResponse;

        /** void	flushBuffer() */
        // Forces any content in the buffer to be written to the client.

        /** int	getBufferSize() */
        // Returns the actual buffer size used for the response.

        /** java.lang.String	getCharacterEncoding() */
        // Returns the name of the character encoding (MIME charset) used for the body sent in this response.

        /** java.lang.String	getContentType() */
        // Returns the content type used for the MIME body sent in this response.

        /** java.util.Locale	getLocale() */
        // Returns the locale specified for this response using the setLocale(java.util.Locale) method.

        /** ServletOutputStream	getOutputStream() */
        // Returns a ServletOutputStream suitable for writing binary data in the response.

        /** java.io.PrintWriter	getWriter() */
        // Returns a PrintWriter object that can send character text to the client.

        /** boolean	isCommitted() */
        // Returns a boolean indicating if the response has been committed.

        /** void	reset() */
        // Clears any data that exists in the buffer as well as the status code and headers.

        /** void	resetBuffer() */
        // Clears the content of the underlying buffer in the response without clearing headers or status code.

        /** void	setBufferSize(int size) */
        // Sets the preferred buffer size for the body of the response.

        /** void	setCharacterEncoding(java.lang.String charset) */
        /* Sets the character encoding (MIME charset) of the response being sent to the client,
           for example, to UTF-8. */

        /** void	setContentLength(int len) */
        /* Sets the length of the content body in the response In HTTP servlets,
           this method sets the HTTP Content-Length header. */

        /** void	setContentType(java.lang.String type) */
        /* Sets the content type of the response being sent to the client,
           if the response has not been committed yet. */

        /** void	setLocale(java.util.Locale loc) */
        // Sets the locale of the response, if the response has not been committed yet.

    }

    public void httpServletResponse() {

        HttpServletResponse httpServletResponse;

        /** void	addCookie(Cookie cookie) */
        // Adds the specified cookie to the response.

        /** void	addDateHeader(java.lang.String name, long date) */
        // Adds a response header with the given name and date-value.

        /** void	addHeader(java.lang.String name, java.lang.String value) */
        // Adds a response header with the given name and value.

        /** void	addIntHeader(java.lang.String name, int value) */
        // Adds a response header with the given name and integer value.

        /** boolean	containsHeader(java.lang.String name) */
        // Returns a boolean indicating whether the named response header has already been set.

        /** java.lang.String	encodeRedirectURL(java.lang.String url) */
        /* Encodes the specified URL for use in the sendRedirect method or,
           if encoding is not needed, returns the URL unchanged. */

        /** java.lang.String	encodeURL(java.lang.String url) */
        /* Encodes the specified URL by including the session ID in it, or, if encoding is not needed,
           returns the URL unchanged. */

        /** void	sendError(int sc) */
        // Sends an error response to the client using the specified status code and clearing the buffer.

        /** void	sendError(int sc, java.lang.String msg) */
        // Sends an error response to the client using the specified status.

        /** void	sendRedirect(java.lang.String location) */
        // Sends a temporary redirect response to the client using the specified redirect location URL.

        /** void	setDateHeader(java.lang.String name, long date) */
        // Sets a response header with the given name and date-value.

        /** void	setHeader(java.lang.String name, java.lang.String value) */
        // Sets a response header with the given name and value.

        /** void	setIntHeader(java.lang.String name, int value) */
        // Sets a response header with the given name and integer value.

        /** void	setStatus(int sc) */
        // Sets the status code for this response.

    }




}

