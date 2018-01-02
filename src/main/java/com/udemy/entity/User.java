/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A.
 * Digital Factory - Colpatria
 * http://www.colpatria.com
 *
 * All rights reserved
 * Date: 02/01/2018
 */
package com.udemy.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Comment
 *
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 * @version 3.0.0
 * @since 02/01/2018
 */

@Entity
@Table(name = "users")
public class User {

  @Id
  @Column(name = "username", unique = true, nullable = false, length = 45)
  private String username;

  @Column(name = "password", nullable = false, length = 60)
  private String password;

  @Column(name = "enabled", nullable = false)
  private boolean enabled;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
  private Set<UserRole> userRole = new HashSet<UserRole>();

  public User() {
  }

  public User(String username, String password, boolean enabled) {
    this.username = username;
    this.password = password;
    this.enabled = enabled;
  }

  public User(String username, String password, boolean enabled, Set<UserRole> userRole) {
    this.username = username;
    this.password = password;
    this.enabled = enabled;
    this.userRole = userRole;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public Set<UserRole> getUserRole() {
    return userRole;
  }

  public void setUserRole(Set<UserRole> userRole) {
    this.userRole = userRole;
  }
}
