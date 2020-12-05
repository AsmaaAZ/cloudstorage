package com.udacity.jwdnd.course1.cloudstorage.service;
// @author asmaa **

import com.udacity.jwdnd.course1.cloudstorage.mapper.NotesMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.SuperDuperNotes;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class NotesService {
  private NotesMapper notesMapper;

  public NotesService(NotesMapper notesMapper) {
    this.notesMapper = notesMapper;
  }

  public List<SuperDuperNotes> getAllNotes(Integer userid){
    return notesMapper.getAllNotes(userid);
  }

  public Integer insertNewNote(SuperDuperNotes newNote){
    return notesMapper.insertNote(new SuperDuperNotes(null, newNote.getUserid(),
        newNote.getNoteTitle(), newNote.getNoteDescription()));
  }

  public SuperDuperNotes getNote(Integer noteid){
    return notesMapper.getSDNotes(noteid);
  }

  public int updateNote(SuperDuperNotes note){
    return notesMapper.updateNotes(note.getNoteTitle(), note.getNoteDescription(), note.getNoteId());
  }

  public int deleteNote(Integer noteid){
    return notesMapper.deleteNotes(noteid);
  }
}
