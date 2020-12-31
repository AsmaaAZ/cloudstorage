package com.udacity.jwdnd.course1.cloudstorage.controller;
// @author asmaa **

import com.udacity.jwdnd.course1.cloudstorage.model.SuperDuperUsers;
import com.udacity.jwdnd.course1.cloudstorage.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {
  private UsersService usersService;

  public SignupController(UsersService usersService) {
    this.usersService = usersService;
  }

  @GetMapping("/signup")
  public String getSignupView(){
    return "signup";
  }

  @PostMapping("/signup")
  public String registerNewUser(@ModelAttribute("/signup") SuperDuperUsers user, Model model){
    if(!usersService.availableUsername(user.getUsername())){
      model.addAttribute("FailureMessage", true);
      return "signup";
    } else {
      int rowsAdded = usersService.insertNewUser(user);
      if(rowsAdded == 1)
        model.addAttribute("SuccessfulMessage", true);
        return "login";
    }
  }
}
