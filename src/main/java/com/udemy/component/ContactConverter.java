/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A.
 * Digital Factory - Colpatria
 * http://www.colpatria.com
 *
 * All rights reserved
 * Date: 28/12/2017
 */
package com.udemy.component;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import org.springframework.stereotype.Component;

/**
 * Comment
 *
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 * @version 3.0.0
 * @since 28/12/2017
 */

@Component("contactConverter")
public class ContactConverter {

  public Contact convertContactModel2Contact(ContactModel contactModel) {
    Contact contact = new Contact();

    contact.setId(contactModel.getId());
    contact.setFirstname(contactModel.getFirstname());
    contact.setLastname(contactModel.getLastname());
    contact.setTelephone(contactModel.getTelephone());
    contact.setCity(contactModel.getCity());

    return contact;
  }

  public ContactModel convertContact2ContactModel(Contact contact) {
    ContactModel contactModel = new ContactModel();

    contactModel.setId(contact.getId());
    contactModel.setFirstname(contact.getFirstname());
    contactModel.setLastname(contact.getLastname());
    contactModel.setTelephone(contact.getTelephone());
    contactModel.setCity(contact.getCity());

    return contactModel;
  }

}
