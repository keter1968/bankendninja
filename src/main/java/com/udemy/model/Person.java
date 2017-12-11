/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A. Digital Factory - Colpatria http://www.colpatria.com
 *
 * All rights reserved Date: 20/11/2017
 */
package com.udemy.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 * @version 3.0.0
 * @since 20/11/2017
 */
public class Person {

  @NotNull
  @Size(min = 2, max = 10)
  private String name;

  @NotNull
  @Min(18)
  private int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Person() {}

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
