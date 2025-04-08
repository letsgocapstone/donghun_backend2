package com.example.unoffimap.User.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Table(name="users")
@Entity
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor


public class User implements UserDetails { //Security provide UserDetails

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "index", unique=true)
    private long index;

    @Column(name = "email", unique=true)
    private String email;

    @Column(name = "nickname", unique=true)
    private String nickname;

    @Column(name = "phoneNumber", unique=true)
    private String phoneNumber;

    @Column(name = "password", unique=true)
    private String password;

    @Builder
    public User( String email, String password) {
        this.email = email;
        this.password = password;
    }
    @Override   //권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority("user"));
    }
    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
