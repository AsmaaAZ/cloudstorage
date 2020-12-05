package com.udacity.jwdnd.course1.cloudstorage.service;
// @author asmaa **

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialsMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.SuperDuperCredentials;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CredentialService {
  private CredentialsMapper credentialsMapper;
  private EncryptionService encryptionService;

  public CredentialService(
      CredentialsMapper credentialsMapper,
      EncryptionService encryptionService) {
    this.credentialsMapper = credentialsMapper;
    this.encryptionService = encryptionService;
  }

  public List<SuperDuperCredentials> getAllCreds(Integer userid) {
        return credentialsMapper.getAllCreds(userid);
  }

  public int insertNewCred(SuperDuperCredentials cred){
    SecureRandom random = new SecureRandom();
    byte[] key = new byte[16];
    random.nextBytes(key);
    String encodedKey = Base64.getEncoder().encodeToString(key);
    String encryptedPassword = encryptionService.encryptValue(cred.getPassword(), encodedKey);
    return credentialsMapper.insertCredential(new SuperDuperCredentials(null,cred.getUserid(),
        cred.getUrl(),cred.getUsername(),encodedKey,encryptedPassword));
  }

  public int updateCredential(SuperDuperCredentials cred){
    SecureRandom random = new SecureRandom();
    byte[] key = new byte[16];
    random.nextBytes(key);
    String encodedKey = Base64.getEncoder().encodeToString(key);
    String encryptedPassword = encryptionService.encryptValue(cred.getPassword(), encodedKey);
    return credentialsMapper.updateCredential(new SuperDuperCredentials(cred.getCredentialId(),cred.getUserid(),
        cred.getUrl(),cred.getUsername(),encodedKey,encryptedPassword));
  }

  public int deleteCredential(Integer credid){
    return credentialsMapper.deleteCredential(credid);
  }
}
