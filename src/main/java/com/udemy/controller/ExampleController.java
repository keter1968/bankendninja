/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A. Digital Factory - Colpatria http://www.colpatria.com
 *
 * All rights reserved Date: 14/11/2017
 */
package com.udemy.controller;

import com.udemy.component.ExampleComponent;
import com.udemy.model.Person;
import com.udemy.service.ExampleService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @since 14/11/2017
 * @version 3.0.0
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 */
@Controller
@RequestMapping("/example")
public class ExampleController {

  public static final String EXAMPLE_VIEW = "example";

  @Autowired
  @Qualifier("exampleService")
  private ExampleService exampleService;

  @Autowired
  @Qualifier("exampleComponent")
  private ExampleComponent exampleComponent;

  // Primera forma

  @GetMapping("/exampleString")
  public String exampleString(Model model) {

//    model.addAttribute("name", "Iván");
//    model.addAttribute("person", new Person("Iván", 49));
    exampleComponent.sayHello();
    model.addAttribute("people", exampleService.getListPeople());
    return EXAMPLE_VIEW;
  }

  // Segunda forma

  @GetMapping("/exampleMAV")
  public ModelAndView exampleMAV() {

    ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
//    mav.addObject("name", "Alejandro");
//    mav.addObject("person", new Person("Alejandro", 32));
    mav.addObject("people", exampleService.getListPeople());
    return mav;
  }


}
