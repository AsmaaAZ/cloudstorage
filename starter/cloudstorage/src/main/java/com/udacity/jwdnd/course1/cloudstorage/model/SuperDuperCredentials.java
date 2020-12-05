package com.udacity.jwdnd.course1.cloudstorage.model;
// @author asmaa **


public class SuperDuperCredentials {
  private Integer credentialId, userid;
  private String url, username, key, password;

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

  public Integer getCredentialId() {
    return credentialId;
  }

  public void setCredentialId(Integer credentialId) {
    this.credentialId = credentialId;
  }

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "SuperDuperCredentials{" +
        "credentialId=" + credentialId +
        ", userid=" + userid +
        ", url='" + url + '\'' +
        ", username='" + username + '\'' +
        ", key='" + key + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
