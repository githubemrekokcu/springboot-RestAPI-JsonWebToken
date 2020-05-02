package com.kokcuemre.spring.security.jwt.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kokcuemre.spring.security.jwt.domain.SSUser;
import com.kokcuemre.spring.security.jwt.repository.SSUserRepository;
import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private SSUserRepository ssUserRepository;

    public UserDetailsServiceImpl(SSUserRepository ssUserRepository) {
        this.ssUserRepository = ssUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SSUser user = ssUserRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(user.getUserName(), user.getPassword(), emptyList());
    }
}
