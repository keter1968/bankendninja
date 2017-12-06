/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A.
 * Digital Factory - Colpatria
 * http://www.colpatria.com
 *
 * All rights reserved
 * Date: 06/12/2017
 */
package com.udemy.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Comment
 *
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 * @version 3.0.0
 * @since 06/12/2017
 */
@ControllerAdvice
public class ErrorsController {

  public static final String ISE_VIEW = "error/500";

  @ExceptionHandler(Exception.class)
  public String showInternalError() {
    return ISE_VIEW;
  }
}
