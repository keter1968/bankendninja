/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A.
 * Digital Factory - Colpatria
 * http://www.colpatria.com
 *
 * All rights reserved
 * Date: 02/01/2018
 */
package com.udemy.service.impl;


import com.udemy.entity.User;
import com.udemy.entity.UserRole;
import com.udemy.repository.UserRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Comment
 *
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 * @version 3.0.0
 * @since 02/01/2018
 */

@Service("userService")
public class UserService implements UserDetailsService {

  @Autowired
  @Qualifier("userRepository")
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = userRepository.findByUsername(username);
    List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());

    return buildUser(user, authorities);
  }

  private org.springframework.security.core.userdetails.User buildUser(User user, List<GrantedAuthority> authorities) {

    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true,
        true, authorities);
  }

  private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles) {
    Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();

    for (UserRole userRole : userRoles) {
      auths.add(new SimpleGrantedAuthority(userRole.getRole()));
    }
    return new ArrayList<GrantedAuthority>(auths);
  }
}
