package com.udacity.jwdnd.course1.cloudstorage.service;
// @author asmaa **


import com.udacity.jwdnd.course1.cloudstorage.mapper.UsersMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.SuperDuperUsers;
import java.util.ArrayList;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class SuperDuperAuthenticationService implements AuthenticationProvider {
  private UsersMapper usersMapper;
  private HashService hashService;

  public SuperDuperAuthenticationService(UsersMapper usersMapper, HashService hashService) {
    this.usersMapper = usersMapper;
    this.hashService = hashService;
  }

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getName();
    String password = authentication.getCredentials().toString();

    SuperDuperUsers user = usersMapper.getUser(username);
    if (user != null){
      String encodedSalt = user.getSalt();
      String hashedPassword = hashService.getHashedValue(password, encodedSalt);
      if (hashedPassword.equals(user.getPassword())){
        return new UsernamePasswordAuthenticationToken(username,password,new ArrayList<>());
      }
    }
    return null;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}
