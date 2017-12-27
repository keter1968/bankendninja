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
import com.udemy.model.ContactModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

  private static final Log LOG = LogFactory.getLog(ContactController.class);

  @GetMapping("/cancel")
  public String cancel() {
    return ViewConstant.CONTACTS;
  }

  @GetMapping("/contactform")
  public String redirectContactForm(Model model) {

    model.addAttribute("contactModel", new ContactModel());
    return ViewConstant.CONTACT_FORM;
  }

  @PostMapping("/addcontact")
  public String addContact(@ModelAttribute(name="contactModel") ContactModel contactModel, Model model) {
    LOG.info("METHOD: addContact() -- PARAMS: " + contactModel.toString());
    model.addAttribute("result", 1);
    return ViewConstant.CONTACTS;
  }
}
