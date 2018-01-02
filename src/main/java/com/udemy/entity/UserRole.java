/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A.
 * Digital Factory - Colpatria
 * http://www.colpatria.com
 *
 * All rights reserved
 * Date: 02/01/2018
 */
package com.udemy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Comment
 *
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 * @version 3.0.0
 * @since 02/01/2018
 */

@Entity
@Table(name = "user_roles", uniqueConstraints = @UniqueConstraint(
    columnNames = {"role", "username"}
))

public class UserRole {

  @Id
  @GeneratedValue
  @Column(name = "user_role_id", unique = true, nullable = false)
  private Integer userRoleId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "username", nullable = false)
  private User user;

  @Column(name = "role", nullable = false, length = 45)
  private String role;

  public UserRole() {
  }

  public UserRole(User user, String role) {
    this.user = user;
    this.role = role;
  }

  public Integer getUserRoleId() {
    return userRoleId;
  }

  public void setUserRoleId(Integer userRoleId) {
    this.userRoleId = userRoleId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
}
