package com.udacity.jwdnd.course1.cloudstorage.model;
// @author asmaa **

import lombok.Getter;
import lombok.Setter;

public class SuperDuperCredentials {
  private @Getter @Setter
  Integer credentialId, userid;
  private @Getter @Setter String url, username, key, password;

  public SuperDuperCredentials(Integer credentialId, Integer userid, String url,
      String username, String key, String password) {
    this.credentialId = credentialId;
    this.userid = userid;
    this.url = url;
    this.username = username;
    this.key = key;
    this.password = password;
  }

  public SuperDuperCredentials() {
  }
}
