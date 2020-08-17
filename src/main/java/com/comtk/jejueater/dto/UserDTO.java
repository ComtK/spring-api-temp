package com.comtk.jejueater.dto;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity(name="user")
public class UserDTO implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String name;
    private String password;
    private String token;
    @ColumnDefault("true")
    private boolean isEnabled;
    @ColumnDefault("true")
    private boolean isAccountNonExpired;
    @ColumnDefault("true")
    private boolean isAccountNonLocked;
    @ColumnDefault("true")
    private boolean isCredentialsNonExpired;
    @Transient
    private Collection<? extends GrantedAuthority> authorities;

}
