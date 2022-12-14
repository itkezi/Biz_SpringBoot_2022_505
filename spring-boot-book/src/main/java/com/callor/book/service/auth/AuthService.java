package com.callor.book.service.auth;

import com.callor.book.model.UserVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class AuthService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(username.equals("callor88")) {
            throw new UsernameNotFoundException(username + "아이디 이상함");
        }

        List<GrantedAuthority> authList = new ArrayList<>();
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));

            UserVO userVO = UserVO.builder()
                    .username(username)
                    .password("!aa1234")
                    .enabled(true)
                    .authorities(authList)
                    .build();

        return userVO;
    }
}
