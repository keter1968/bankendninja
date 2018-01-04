package com.udemy.controller;

import com.udemy.model.ContactModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

//  @GetMapping("/checkrest")
//  public ResponseEntity<String> checkRest() {
//    return new ResponseEntity<String>("OK", HttpStatus.OK);
//  }
@GetMapping("/checkrest")
public ResponseEntity<ContactModel> checkRest() {
  ContactModel contactModel = new ContactModel(2, "juan", "perez", "31068883546", "bogota");
  return new ResponseEntity<ContactModel>(contactModel, HttpStatus.OK);
}
}
