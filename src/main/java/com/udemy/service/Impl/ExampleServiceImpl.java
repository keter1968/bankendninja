/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A.
 * Digital Factory - Colpatria
 * http://www.colpatria.com
 *
 * All rights reserved
 * Date: 11/12/2017
 */
package com.udemy.service.Impl;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * Comment
 *
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 * @version 3.0.0
 * @since 11/12/2017
 */

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

  private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

  @Override
  public List<Person> getListPeople() {
    List<Person> people = new ArrayList<>();
    people.add(new Person("Alejandro", 32));
    people.add(new Person("Beatriz", 16));
    people.add(new Person("Natalia", 28));
    people.add(new Person("Alberto", 47));
    people.add(new Person("Juan", 8));
    LOG.info("HELLO FROM SERVICE");
    return people;
  }
}
