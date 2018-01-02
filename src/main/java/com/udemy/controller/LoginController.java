/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A.
 * Digital Factory - Colpatria
 * http://www.colpatria.com
 *
 * All rights reserved
 * Date: 22/12/2017
 */
package com.udemy.controller;

import com.udemy.constant.ViewConstant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Comment
 *
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 * @version 3.0.0
 * @since 22/12/2017
 */

@Controller
public class LoginController {

  private static final Log LOG = LogFactory.getLog(LoginController.class);

  @GetMapping("/login")
  public String showLoginForm(Model model,
      @RequestParam(name = "error", required = false) String error,
      @RequestParam(name = "logout", required = false) String logout) {
    LOG.info("METHOD: showLoginForm() -- PARAMS: error=" + error + ", logout: " + logout);
    model.addAttribute("error", error);
    model.addAttribute("logout", logout);
    LOG.info("Returning to login view");
    return ViewConstant.LOGIN;
  }

  @GetMapping({"/loginsuccess", "/"})
  public String loginCheck() {

    LOG.info("METHOD: loginCheck()");
    LOG.info("Returning to contacts view");
    return "redirect:/contacts/showcontacts";
  }

}
