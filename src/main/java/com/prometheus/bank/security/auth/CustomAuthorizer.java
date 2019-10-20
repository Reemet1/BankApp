package com.prometheus.bank.security.auth;

import com.prometheus.bank.entity.Role;
import com.prometheus.bank.entity.User;
import com.prometheus.bank.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustomAuthorizer implements AccessDecisionVoter {

    @Autowired
    private UserService userService;

    @Override
    public int vote(Authentication authentication, Object object, Collection collection) {

        String username = authentication.getName();

        if(username.equals("anonymousUser")) return 1;

        User user = userService.getUser(username);

        for(Role role : user.getRoles()) {
            for(GrantedAuthority granted : authentication.getAuthorities()) {
                if(granted.getAuthority().equals(role.getRoleName())) return 1;
            }
        }

        return 0;
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class clazz) {
        return true;
    }
}