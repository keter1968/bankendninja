/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A. Digital Factory - Colpatria http://www.colpatria.com
 *
 * All rights reserved Date: 2/12/2017
 */
package com.udemy.controller;

import com.udemy.model.Person;
import java.lang.ProcessBuilder.Redirect;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @since 2/12/2017
 * @version 3.0.0
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 */
@Controller
@RequestMapping("/example3")
public class Example3Controller {

  private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);

  public static final String FORM_VIEW = "form";
  public static final String RESULT_VIEW = "result";

  //Redireccionar
  // 1
  /*@GetMapping("/")
  public String redirect() {
    return "redirect:/example3/showform";
  }*/

  // 2
  @GetMapping("/")
  public RedirectView redirect() {
    return new RedirectView("/example3/showform");
  }

  @GetMapping("/showform")
  public String showForm(Model model) {
    model.addAttribute("person", new Person());
    return FORM_VIEW;
  }

  @PostMapping("/addperson")
    public ModelAndView addPerson(@ModelAttribute("person") Person person) {
    LOGGER.info("METHOD: 'addPerson' -- PARAMS: '" + person + "'");
    ModelAndView mav = new ModelAndView(RESULT_VIEW);
    mav.addObject("person", person);
    LOGGER.info("TEMPLATE: '" + RESULT_VIEW + "' -- DATA: '" + person + "'");
    return mav;
  }

}
