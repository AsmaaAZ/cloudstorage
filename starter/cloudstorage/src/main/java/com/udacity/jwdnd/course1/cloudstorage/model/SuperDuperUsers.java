package com.udacity.jwdnd.course1.cloudstorage.model;
// @author asmaa **


public class SuperDuperUsers {
  private Integer userid;
  private String username, password, salt, firstname, lastname;

  public SuperDuperUsers(Integer userid, String username, String password, String salt,
      String firstname, String lastname) {
    this.userid = userid;
    this.username = username;
    this.password = password;
    this.salt = salt;
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }
}
