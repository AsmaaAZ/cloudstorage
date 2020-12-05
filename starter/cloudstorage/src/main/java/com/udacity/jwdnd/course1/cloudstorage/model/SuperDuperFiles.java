package com.udacity.jwdnd.course1.cloudstorage.model;
// @author asmaa **


public class SuperDuperFiles {
  private Integer fileId, userid;
  private String filename, contenttype, filesize;
  private byte[] filedata;

  public SuperDuperFiles(Integer fileId, Integer userid, String filename, String contenttype, String filesize, byte[] filedata) {
    this.fileId = fileId;
    this.userid = userid;
    this.filename = filename;
    this.contenttype = contenttype;
    this.filesize = filesize;
    this.filedata = filedata;
  }

  public SuperDuperFiles() {
  }

  public Integer getFileId() {
    return fileId;
  }

  public void setFileId(Integer fileId) {
    this.fileId = fileId;
  }

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public String getContenttype() {
    return contenttype;
  }

  public void setContenttype(String contenttype) {
    this.contenttype = contenttype;
  }

  public byte[] getFiledata() {
    return filedata;
  }

  public void setFiledata(byte[] filedata) {
    this.filedata = filedata;
  }

  public String getFilesize() {
    return filesize;
  }

  public void setFilesize(String filesize) {
    this.filesize = filesize;
  }
}
