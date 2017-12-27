/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A.
 * Digital Factory - Colpatria
 * http://www.colpatria.com
 *
 * All rights reserved
 * Date: 27/12/2017
 */
package com.udemy.model;

/**
 * Comment
 *
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 * @version 3.0.0
 * @since 27/12/2017
 */
public class ContactModel {

  private int id;
  private String firstname;
  private String lastname;
  private String telephone;
  private String city;

  public ContactModel() {
  }

  public ContactModel(int id, String firstname, String lastname, String telephone, String city) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.telephone = telephone;
    this.city = city;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}