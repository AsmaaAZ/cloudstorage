package com.udacity.jwdnd.course1.cloudstorage.model;
// @author asmaa **


import lombok.Getter;
import lombok.Setter;

public class SuperDuperUsers {
  private @Getter @Setter Integer userid;
  private @Getter @Setter String username, password, salt, firstname, lastname;

  public SuperDuperUsers(Integer userid, String username, String password, String salt,
      String firstname, String lastname) {
    this.userid = userid;
    this.username = username;
    this.password = password;
    this.salt = salt;
    this.firstname = firstname;
    this.lastname = lastname;
  }
}
