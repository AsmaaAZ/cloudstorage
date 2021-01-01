package com.udacity.jwdnd.course1.cloudstorage.model;
// @author asmaa **


import lombok.Getter;
import lombok.Setter;

public class SuperDuperFiles {
  private @Getter @Setter
  Integer fileId, userid;
  private @Getter @Setter String filename, contenttype, filesize;
  private @Getter @Setter byte[] filedata;

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
}
