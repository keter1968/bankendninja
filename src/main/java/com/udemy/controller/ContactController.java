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
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import com.udemy.service.ContactService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

  @Autowired
  @Qualifier("contactServiceImpl")
  private ContactService contactService;

  @GetMapping("/cancel")
  public String cancel() {
    return "redirect:/contacts/showcontacts";
  }

  @GetMapping("/contactform")
  public String redirectContactForm(@RequestParam(name = "id", required = false) int id, Model model) {
    ContactModel contactModel = new ContactModel();
    if (id != 0) {
      contactModel = contactService.findByIdModel(id);
    }
    model.addAttribute("contactModel", contactModel);
    return ViewConstant.CONTACT_FORM;
  }

  @PostMapping("/addcontact")
  public String addContact(@ModelAttribute(name = "contactModel") ContactModel contactModel, Model model) {
    LOG.info("METHOD: addContact() -- PARAMS: " + contactModel.toString());

    if (null != contactService.addContact(contactModel)) {
      model.addAttribute("result", 1);
    } else {
      model.addAttribute("result", 0);
    }

    return "redirect:/contacts/showcontacts";
  }

  @GetMapping("/showcontacts")
  private ModelAndView showContacts() {
    ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
    mav.addObject("contacts", contactService.listAllContacts());

    return mav;
  }

  @GetMapping("/removecontact")
  private ModelAndView removeContact(@RequestParam(name = "id", required = true) int id) {
    contactService.removeContact(id);
    return showContacts();
  }
}
