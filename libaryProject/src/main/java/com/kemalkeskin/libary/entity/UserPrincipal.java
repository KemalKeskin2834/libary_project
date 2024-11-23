package com.kemalkeskin.libary.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserPrincipal implements UserDetails {
    private User user;

    @Autowired
    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ADMIN"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        // kullanıcı hesabının süresinin dolup dolmadığını gösteriri eğer false döerse dolmuş olur
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // hesabın kapatılıp kapanmadığını veya kililitli gösteririr
        // eğer false dersek hesap kilitli anlamına denk gelir
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // bir kullanıcın kimlik bilgilerinin ahlen geçerli olup olmadığını soyler
        return true;
    }

    @Override
    public boolean isEnabled() {
        // kullanıcının sistemde aktif olup olmadığına bakar
        return true;
    }
}
