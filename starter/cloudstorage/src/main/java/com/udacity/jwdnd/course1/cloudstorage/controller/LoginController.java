package com.udacity.jwdnd.course1.cloudstorage.controller;
// @author asmaa **

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
  @GetMapping("/login")
  public String getLoginView(){
    return "/login";
  }

}
