package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.SuperDuperUsers;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UsersMapper {
  @Select("SELECT * FROM USERS WHERE username = #{username}")
  SuperDuperUsers getUser(String username);

  @Insert("INSERT INTO USERS (username, password, salt, firstname, lastname)"
      + "VALUES(#{username},#{password},#{salt},#{firstname},#{lastname})")
  @Options(useGeneratedKeys = true, keyProperty = "userid")
  int insertUser(SuperDuperUsers user);

  @Update("UPDATE USERS SET username = #{username}, password = #{password}, salt = #{salt}, "
      + "firstname = #{firstname}, lastname = #{lastname} WHERE userid = #{userid}")
  void updateUser(SuperDuperUsers user);

  @Delete("DELETE FROM USERS WHERE username = #{username}")
  void deleteUser(String username);
}