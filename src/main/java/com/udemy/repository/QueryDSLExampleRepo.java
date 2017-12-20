/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A.
 * Digital Factory - Colpatria
 * http://www.colpatria.com
 *
 * All rights reserved
 * Date: 20/12/2017
 */
package com.udemy.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.entity.Course;
import com.udemy.entity.QCourse;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 * Comment
 *
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 * @version 3.0.0
 * @since 20/12/2017
 */

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {

  private QCourse qCourse = QCourse.course;

  @PersistenceContext
  private EntityManager entityManager;

  public Course find(boolean exist) {

    JPAQuery<Course> query = new JPAQuery<Course>(entityManager);

    BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));

    if (exist) {
      Predicate predicate2 = qCourse.id.eq(23);
      predicateBuilder.and(predicate2);
    } else {
      Predicate predicate3 = qCourse.name.endsWith("OP");
      predicateBuilder.and(predicate3);
    }

    return query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
  }
}
