/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A.
 * Digital Factory - Colpatria
 * http://www.colpatria.com
 *
 * All rights reserved
 * Date: 11/12/2017
 */
package com.udemy.component;

import com.udemy.repository.LogRepository;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Comment
 *x
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 * @version 3.0.0
 * @since 11/12/2017
 */

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

  @Autowired
  @Qualifier("logRepository")
  private LogRepository logRepository;

  private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

  //Primero
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    request.setAttribute("startTime", System.currentTimeMillis());
    return true;
  }

  //Segundo
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    super.afterCompletion(request, response, handler, ex);
    long startTime = (long) request.getAttribute("startTime");
    String url = request.getRequestURL().toString();

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username = "";
    if (authentication != null && authentication.isAuthenticated()) {
      username = authentication.getName();
    }

    logRepository.save(new com.udemy.entity.Log(new Date(), authentication.getDetails().toString(), username, url));
    LOG.info("URL to: '" + url + "' in '" + (System.currentTimeMillis() - startTime) + "'ms");
  }
}
