package com.comtk.jejueater.config;

import com.comtk.jejueater.dto.UserAuthorityDTO;
import com.comtk.jejueater.dto.UserDTO;
import com.comtk.jejueater.repository.UserAuthorityRepository;
import com.comtk.jejueater.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAuthorityRepository userAuthorityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = userRepository.findByUsername(username);
        user.setAuthorities(getAuthorities(username));
        return user;
    }

    private Collection<GrantedAuthority> getAuthorities(String username){
        ArrayList<UserAuthorityDTO> authList = userAuthorityRepository.findByUsername(username);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (UserAuthorityDTO authority : authList) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+authority.getAuthority()));
        }
        return authorities;
    }

}
