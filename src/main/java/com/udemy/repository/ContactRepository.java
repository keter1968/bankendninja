/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A.
 * Digital Factory - Colpatria
 * http://www.colpatria.com
 *
 * All rights reserved
 * Date: 27/12/2017
 */
package com.udemy.repository;

import com.udemy.entity.Contact;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Comment
 *
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 * @version 3.0.0
 * @since 27/12/2017
 */

@Repository("contactRepository")
public interface ContactRepository  extends JpaRepository<Contact, Serializable> {

  public abstract Contact findById(int id);
}
