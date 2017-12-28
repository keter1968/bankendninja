/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A.
 * Digital Factory - Colpatria
 * http://www.colpatria.com
 *
 * All rights reserved
 * Date: 28/12/2017
 */
package com.udemy.service.impl;

import com.udemy.component.ContactConverter;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import com.udemy.repository.ContactRepository;
import com.udemy.service.ContactService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Comment
 *
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 * @version 3.0.0
 * @since 28/12/2017
 */

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

  @Autowired
  @Qualifier("contactRepository")
  private ContactRepository contactRepository;

  @Autowired
  @Qualifier("contactConverter")
  private ContactConverter contactConverter;

  @Override
  public ContactModel addContact(ContactModel contactModel) {

    Contact contact = contactRepository.save(contactConverter.convertContactModel2Contact(contactModel));
    return contactConverter.convertContact2ContactModel(contact);
  }

  @Override
  public List<ContactModel> listAllContacts() {

    List<Contact> contacts = contactRepository.findAll();
    List<ContactModel> contactModels = new ArrayList<ContactModel>();
    for (Contact contact: contacts) {
      contactModels.add(contactConverter.convertContact2ContactModel(contact));
    }
    return contactModels;
  }
}
