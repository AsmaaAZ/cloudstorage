package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.SuperDuperCredentials;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CredentialsMapper {

  @Select("SELECT * FROM CREDENTIALS WHERE credentialId = #{credentialId}")
  SuperDuperCredentials getCredential(Integer credentialId);

  @Select("SELECT * FROM CREDENTIALS WHERE userid = #{userid}")
  List<SuperDuperCredentials> getAllCreds(Integer userid);

  @Insert("INSERT INTO CREDENTIALS (userid, url, username, key, password)"
      + " VALUES (#{userid}, #{url},#{username},#{key},#{password})")
  @Options(useGeneratedKeys = true, keyProperty = "credentialId")
  int insertCredential(SuperDuperCredentials cred);

  @Update("UPDATE CREDENTIALS SET url = #{url}, username = #{username}, "
      + "key = #{key}, password = #{password} WHERE credentialId = #{credentialId}")
  int updateCredential(SuperDuperCredentials credential);

  @Delete("DELETE FROM CREDENTIALS WHERE credentialId = #{credentialId}")
  int deleteCredential(Integer credentialId);
}