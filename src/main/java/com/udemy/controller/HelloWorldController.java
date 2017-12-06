/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A. Digital Factory - Colpatria http://www.colpatria.com
 *
 * All rights reserved Date: 7/11/2017
 */
package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @since 7/11/2017
 * @version 3.0.0
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 */
@Controller
@RequestMapping("/say")
public class HelloWorldController {

  @GetMapping("/helloworld")
  public String helloWorld() {
    return "helloworld";
  }
}
