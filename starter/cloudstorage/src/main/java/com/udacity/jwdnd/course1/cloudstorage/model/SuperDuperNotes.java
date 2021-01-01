package com.udacity.jwdnd.course1.cloudstorage.model;
// @author asmaa **


import lombok.Getter;
import lombok.Setter;

public class SuperDuperNotes {
  private @Getter @Setter
  Integer noteId, userid;
  private @Getter @Setter String noteTitle, noteDescription;

  public SuperDuperNotes() {
  }

  public SuperDuperNotes(Integer noteId, Integer userid, String noteTitle,
      String noteDescription) {
    this.noteId = noteId;
    this.userid = userid;
    this.noteTitle = noteTitle;
    this.noteDescription = noteDescription;
  }
}
