package com.company.security.service;

import com.company.entity.Student;
import com.company.service.inter.StudentServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private StudentServiceInter studentServiceInter;

    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Student st=studentServiceInter.findByName(name);
        if (st != null) {
            UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(name);
            builder.disabled(false);
            builder.password(st.getPassword());
            String[] authoritiesArr = new String[]{"ADMIN", "USER"};
            builder.authorities(authoritiesArr);
            return builder.build();
        } else {
            throw new UsernameNotFoundException("User not found !");
        }

    }
}
