package com.kemalkeskin.libary.security;

import com.kemalkeskin.libary.core.exception.BusinessException;
import com.kemalkeskin.libary.entity.User;
import com.kemalkeskin.libary.entity.UserPrincipal;
import com.kemalkeskin.libary.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       User user=userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("don't found user"));

       return new UserPrincipal(user);
    }

}
