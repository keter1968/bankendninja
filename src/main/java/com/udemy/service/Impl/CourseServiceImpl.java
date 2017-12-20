package com.udemy.service.Impl;

import com.udemy.entity.Course;
import com.udemy.repository.CourseJpaRepository;
import com.udemy.service.CourseService;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

  private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

  @Autowired
  @Qualifier("courseJpaRepository")
  private CourseJpaRepository courseJpaRepository;

  @Override
  public List<Course> listAllCourse() {
    LOG.info("Call: " + "listAllCourse()");
    return courseJpaRepository.findAll();
  }

  @Override
  public Course addCourse(Course course) {
    LOG.info("Call: " + "addCourse()");
    return courseJpaRepository.save(course);
  }

  @Override
  public Course updateCourse(Course course) {
    LOG.info("Call: " + "updateCourse()");
    return courseJpaRepository.save(course);
  }

  @Override
  public int removeCourse(int id) {
    LOG.info("Call: " + "removeCourse()");
    courseJpaRepository.delete(id);
    return 0;
  }
}
