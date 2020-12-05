package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.SuperDuperFiles;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface FilesMapper {
  @Select("SELECT * FROM FILES WHERE userid = #{userid}")
  List<SuperDuperFiles> getAllFiles(Integer userid);

  @Select("SELECT * FROM FILES WHERE fileId = #{fileId}")
  SuperDuperFiles getSDFile(Integer fileId);

  @Select("SELECT * FROM FILES WHERE filename = #{fileName}")
  SuperDuperFiles getSDFileByName(String fileName);

  @Insert("INSERT INTO FILES (userid, filename, contenttype, filesize, filedata) "
      + "VALUES(#{userid},#{filename},#{contenttype},#{filesize},#{filedata})")
  @Options(useGeneratedKeys = true, keyProperty = "fileId")
  int insertSDFile(SuperDuperFiles file);

  @Update("UPDATE FILES set filename = #{filename}, contenttype = #{contenttype}, "
      + "filesize = #{filesize}, filedata = #{filedata} WHERE fileId = #{fileId}")
  void updateSDFile(SuperDuperFiles file);

  @Delete("DELETE FROM FILES WHERE fileId = #{fileId}")
  int deleteSDFile(Integer fileId);
}
