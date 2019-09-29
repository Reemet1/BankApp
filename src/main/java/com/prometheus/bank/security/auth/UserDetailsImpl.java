package com.prometheus.bank.security.auth;

import com.prometheus.bank.dao.UserDAO;
import com.prometheus.bank.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.prometheus.bank.entity.User user = userDAO.getUser(username);

        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return User.withUsername(username).password(user.getPassword()).authorities(authorities).build();
    }
}
