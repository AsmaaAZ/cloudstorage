package com.udacity.jwdnd.course1.cloudstorage.service;
// @author asmaa **

import com.udacity.jwdnd.course1.cloudstorage.mapper.UsersMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.SuperDuperUsers;
import java.security.SecureRandom;
import java.util.Base64;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
  private UsersMapper usersMapper;
  private HashService hashService;

  public UsersService(UsersMapper usersMapper, HashService hashService) {
    this.usersMapper = usersMapper;
    this.hashService = hashService;
  }

  //user not exist
  public boolean availableUsername(String username){
    return usersMapper.getUser(username) == null;
  }

  public int insertNewUser(SuperDuperUsers user){
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[16];
    random.nextBytes(salt);
    String encodedSalt = Base64.getEncoder().encodeToString(salt);
    String hashedValue = hashService.getHashedValue(user.getPassword(),encodedSalt);
    return usersMapper.insertUser(new SuperDuperUsers(null,
        user.getUsername(),hashedValue,encodedSalt,
        user.getFirstname(),user.getLastname()));
  }

  public SuperDuperUsers getUser(String username){
    return usersMapper.getUser(username);
  }

}