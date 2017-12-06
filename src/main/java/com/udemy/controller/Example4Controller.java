/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A.
 * Digital Factory - Colpatria
 * http://www.colpatria.com
 *
 * All rights reserved
 * Date: 06/12/2017
 */
package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Comment
 *
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 * @version 3.0.0
 * @since 06/12/2017
 */
@Controller
@RequestMapping("/example4")
public class Example4Controller {

  public static final String ERROR_VIEW_404 = "404";
  public static final String ERROR_VIEW_500 = "500";

  @GetMapping("/example404")
  public ModelAndView example404() {

    ModelAndView mav = new ModelAndView(ERROR_VIEW_404);
    return mav;
  }

  @GetMapping("/example500")
  public ModelAndView example500() {

    ModelAndView mav = new ModelAndView(ERROR_VIEW_500);
    return mav;
  }
}
