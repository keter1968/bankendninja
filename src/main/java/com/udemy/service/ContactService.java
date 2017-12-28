/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A.
 * Digital Factory - Colpatria
 * http://www.colpatria.com
 *
 * All rights reserved
 * Date: 28/12/2017
 */
package com.udemy.service;

import com.udemy.model.ContactModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Comment
 *
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 * @version 3.0.0
 * @since 28/12/2017
 */

public interface ContactService {

  public abstract ContactModel addContact(ContactModel contactModel);

  public abstract List<ContactModel> listAllContacts();
}
