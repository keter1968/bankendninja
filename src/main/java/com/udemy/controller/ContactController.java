/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A.
 * Digital Factory - Colpatria
 * http://www.colpatria.com
 *
 * All rights reserved
 * Date: 27/12/2017
 */
package com.udemy.controller;

import com.udemy.constant.ViewConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Comment
 *
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 * @version 3.0.0
 * @since 27/12/2017
 */

@Controller
@RequestMapping("/contacts")
public class ContactController {

  @GetMapping("/contactform")
  private String redirectContactForm() {
    return ViewConstant.CONTACT_FORM;
  }
}
