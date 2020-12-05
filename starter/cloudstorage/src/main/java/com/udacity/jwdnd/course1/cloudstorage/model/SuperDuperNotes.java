package com.udacity.jwdnd.course1.cloudstorage.model;
// @author asmaa **


public class SuperDuperNotes {
  private Integer noteId, userid;
  private String noteTitle, noteDescription;

  public SuperDuperNotes() {
  }

  public SuperDuperNotes(Integer noteId, Integer userid, String noteTitle,
      String noteDescription) {
    this.noteId = noteId;
    this.userid = userid;
    this.noteTitle = noteTitle;
    this.noteDescription = noteDescription;
  }

  public Integer getNoteId() {
    return noteId;
  }

  public void setNoteId(Integer noteId) {
    this.noteId = noteId;
  }

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  public String getNoteTitle() {
    return noteTitle;
  }

  public void setNoteTitle(String noteTitle) {
    this.noteTitle = noteTitle;
  }

  public String getNoteDescription() {
    return noteDescription;
  }

  public void setNoteDescription(String noteDescription) {
    this.noteDescription = noteDescription;
  }

  @Override
  public String toString() {
    return "SuperDuperNotes{" +
        "noteId=" + noteId +
        ", userid=" + userid +
        ", noteTitle='" + noteTitle + '\'' +
        ", noteDescription='" + noteDescription + '\'' +
        '}';
  }
}
