package com.udacity.jwdnd.course1.cloudstorage.controller;
// @author asmaa **

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class SuperDuperErrorController{
  @ExceptionHandler(MaxUploadSizeExceededException.class)
  public String handleError(MaxUploadSizeExceededException e, RedirectAttributes redirectAttributes, Model model){
    model.addAttribute("fileTooBigFailure", true);
    redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
    return "result";
  }
}
