package com.prometheus.bank.security.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    // Just for setting the default target URL
    public LogoutSuccessHandler() {
        this.setDefaultTargetUrl("/adminhome");
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        // do whatever you want
        super.onLogoutSuccess(request, response, authentication);
    }
}