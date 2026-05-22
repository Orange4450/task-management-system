package com.Boltabay_Zhaniya.taskmanagement.security;

import com.Boltabay_Zhaniya.taskmanagement.entity.Boltabay_Zhaniya_User;
import com.Boltabay_Zhaniya.taskmanagement.repository.Boltabay_Zhaniya_UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Boltabay_Zhaniya_UserDetailsService implements UserDetailsService {

    private final Boltabay_Zhaniya_UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        Boltabay_Zhaniya_User user = repository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                List.of(
                        new SimpleGrantedAuthority(
                                user.getRole().getName()
                        )
                )
        );
    }
}