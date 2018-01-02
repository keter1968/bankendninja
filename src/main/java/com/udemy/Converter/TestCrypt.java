/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A.
 * Digital Factory - Colpatria
 * http://www.colpatria.com
 *
 * All rights reserved
 * Date: 02/01/2018
 */
package com.udemy.Converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Comment
 *
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 * @version 3.0.0
 * @since 02/01/2018
 */
public class TestCrypt {

  public static void main(String[] args) {
    BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
    System.out.println(pe.encode("user"));
  }
}
