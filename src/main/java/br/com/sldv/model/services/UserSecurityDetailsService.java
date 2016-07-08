package br.com.sldv.model.services;


import br.com.sldv.model.domains.User;
import br.com.sldv.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("UserSecurityDetailsService")
public class UserSecurityDetailsService implements UserDetailsService {

    @Autowired
    UserRepository usuarioRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails
      loadUserByUsername(String username) throws UsernameNotFoundException {

        User user  = usuarioRepository.findByUsername(username);

        if(user == null)
            throw new UsernameNotFoundException("User not found");

        List<GrantedAuthority> grantedAuthorities;

        grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getPermission().toString()));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                grantedAuthorities);

    }
}
