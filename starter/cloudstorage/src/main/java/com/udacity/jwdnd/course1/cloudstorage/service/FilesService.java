package com.udacity.jwdnd.course1.cloudstorage.service;
// @author asmaa **


import com.udacity.jwdnd.course1.cloudstorage.mapper.FilesMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.SuperDuperFiles;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FilesService {
  private FilesMapper filesMapper;

  public FilesService(FilesMapper filesMapper) {
    this.filesMapper = filesMapper;
  }

  public SuperDuperFiles getFile(Integer fileId){
    return filesMapper.getSDFile(fileId);
  }

  public List<SuperDuperFiles> getAllFiles(Integer userid){
    return filesMapper.getAllFiles(userid);
  }

  public Integer insertFile(SuperDuperFiles file){
    return filesMapper.insertSDFile(new SuperDuperFiles(null, file.getUserid(), file.getFilename(), file.getContenttype(),
        file.getFilesize(), file.getFiledata()));
  }

  public int deleteFile(Integer fileId){
    return filesMapper.deleteSDFile(fileId);
  }

  public boolean isFileExist(String fileName){
    return filesMapper.getSDFileByName(fileName) == null;
  }
}
