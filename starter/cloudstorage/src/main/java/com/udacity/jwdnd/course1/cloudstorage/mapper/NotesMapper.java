package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.SuperDuperNotes;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface NotesMapper {
  @Select("SELECT * FROM NOTES WHERE userid = #{userid}")
  List<SuperDuperNotes> getAllNotes(Integer userid);

  @Select("SELECT * FROM NOTES WHERE noteId = #{noteId}")
  SuperDuperNotes getSDNotes(Integer noteId);

  @Insert("INSERT INTO NOTES(noteTitle, noteDescription, userid) "
      + "VALUES(#{noteTitle},#{noteDescription},#{userid})")
  @Options(useGeneratedKeys = true, keyProperty = "noteId")
  int insertNote(SuperDuperNotes note);

  @Update("UPDATE NOTES SET noteTitle = #{noteTitle}, noteDescription = #{noteDescription} WHERE noteId = #{noteId}")
  int updateNotes(String noteTitle, String noteDescription,Integer noteId);

  @Delete("DELETE FROM NOTES WHERE noteId = #{noteId}")
  int deleteNotes(Integer noteid);
}