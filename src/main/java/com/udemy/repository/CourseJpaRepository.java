/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A.
 * Digital Factory - Colpatria
 * http://www.colpatria.com
 *
 * All rights reserved
 * Date: 13/12/2017
 */
package com.udemy.repository;

import com.udemy.entity.Course;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Comment
 *
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 * @version 3.0.0
 * @since 13/12/2017
 */

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course, Serializable> {

  public abstract Course findByPrice(int price);

  public abstract Course findByPriceAndName(int price, String name);

  public abstract List<Course> findByNameOrderByHours(String name);

  public abstract Course findByNameOrPrice(String name, int price);
}
