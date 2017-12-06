/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A. Digital Factory - Colpatria http://www.colpatria.com
 *
 * All rights reserved Date: 30/11/2017
 */
package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @since 30/11/2017
 * @version 3.0.0
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 */

@Controller
@RequestMapping("/example2")
public class Example2Controller {

  private static final String EXAMPLE2_MODEL = "example2";

  //localhost:8080/example2/request1?nm=JOHN
  //localhost:8080/example2/request1?nm=ALEX
  @GetMapping("/request1")
  public ModelAndView request1(@RequestParam(name="nm", required = false, defaultValue = "NULL") String name) {
    ModelAndView mav = new ModelAndView(EXAMPLE2_MODEL);
    mav.addObject("nm_in_model", name);
    return mav;
  }

  //localhost:8080/example2/request2/JOHN
  //localhost:8080/example2/request2/ALEX
  @GetMapping("/request2/{nm}")
  public ModelAndView request2(@PathVariable("nm") String name) {
    ModelAndView mav = new ModelAndView(EXAMPLE2_MODEL);
    mav.addObject("nm_in_model", name);
    return mav;
  }
}
