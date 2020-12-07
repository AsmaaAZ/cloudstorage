package com.udacity.jwdnd.course1.cloudstorage.controller;
// @author asmaa **

import com.udacity.jwdnd.course1.cloudstorage.model.SuperDuperCredentials;
import com.udacity.jwdnd.course1.cloudstorage.model.SuperDuperFiles;
import com.udacity.jwdnd.course1.cloudstorage.model.SuperDuperNotes;
import com.udacity.jwdnd.course1.cloudstorage.service.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.service.EncryptionService;
import com.udacity.jwdnd.course1.cloudstorage.service.FilesService;
import com.udacity.jwdnd.course1.cloudstorage.service.NotesService;
import com.udacity.jwdnd.course1.cloudstorage.service.UsersService;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {

  private UsersService usersService;
  private FilesService filesService;
  private NotesService notesService;
  private CredentialService credentialService;
  private EncryptionService encryptionService;

  //private CredentialsService credentialService;
  private List<SuperDuperFiles> filesList = new ArrayList<>();
  private List<SuperDuperNotes> notesList = new ArrayList<>();
  private List<SuperDuperCredentials> credsList = new ArrayList<>();


  public HomeController(UsersService usersService,
      FilesService filesService,
      NotesService notesService,
      CredentialService credentialService,
      EncryptionService encryptionService) {
    this.usersService = usersService;
    this.filesService = filesService;
    this.notesService = notesService;
    this.credentialService = credentialService;
    this.encryptionService = encryptionService;
  }

  @GetMapping("/home")
  public String getHomeView(Principal principal, Model model) {
    filesList = filesService.getAllFiles(usersService.getUser(principal.getName()).getUserid());
    notesList = notesService.getAllNotes(usersService.getUser(principal.getName()).getUserid());
    credsList = credentialService.getAllCreds(usersService.getUser(principal.getName()).getUserid());
    model.addAttribute("filesList", filesList);
    model.addAttribute("noteList", notesList);
    model.addAttribute("credsList", credsList);
    model.addAttribute("encryptionService", encryptionService);
    return "home";
  }

//################## Start of File Operations ##################

  @PostMapping("/fileToUpload")
  public String uploadingFile(@RequestParam("fileUpload") MultipartFile fileUpload,
      Principal principal, Model model) throws IOException {
    SuperDuperFiles file = new SuperDuperFiles(null,
        usersService.getUser(principal.getName()).getUserid(), fileUpload.getOriginalFilename(),
        fileUpload.getContentType(), String.valueOf(fileUpload.getSize()), fileUpload.getBytes());

    if (fileUpload.isEmpty()) {
      model.addAttribute("fileFailure", true);
    } else {
      if (fileUpload.getSize() >= 10 * (1024 * 1024)) {
        model.addAttribute("fileTooBigFailure", true);
        return "result";
      }
      if (!filesService.isFileExist(fileUpload.getOriginalFilename())) {
        model.addAttribute("fileExists", true);
      } else {
        filesService.insertFile(file);
        model.addAttribute("fileSuccess", true);
      }
    }
    return "result";
  }

  @GetMapping("/file/delete")
  public String deletingFile(@RequestParam(value = "fileId") Integer fileId, Model model) {
    Integer rowsDeleted = filesService.deleteFile(fileId);
    if (rowsDeleted != 0) {
      model.addAttribute("fileSuccess", true);
    } else {
      model.addAttribute("fileFailure", true);
    }
    return "result";
  }

  @GetMapping("/file/download")
  public ResponseEntity downloadingFile(@RequestParam(value = "fileId") Integer fileId) {
    SuperDuperFiles df = filesService.getFile(fileId);
    System.out.println(df.getUserid() + df.getFileId() + df.getFilename() + df.getContenttype() + df
        .getFilesize());
    return ResponseEntity.ok().contentType(MediaType.parseMediaType(df.getContenttype()))
        .header(HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename:\"" + df.getFilename() + "\"")
        .body(df.getFiledata());
  }

  //################ End of Files Operations ##############
  //################ Start of Notes Operations #############

  @PostMapping("/noteToAdd")
  public String handleNote(@ModelAttribute("noteToAdd") SuperDuperNotes note, Principal principal, Model model) {
    SuperDuperNotes newNote = new SuperDuperNotes(note.getNoteId(),
        usersService.getUser(principal.getName()).getUserid(), note.getNoteTitle(),
        note.getNoteDescription());

    if (newNote.getNoteId() == null) {
      int rowsAdded = notesService.insertNewNote(newNote);
      if (rowsAdded == 1) {
        model.addAttribute("noteSuccess", true);
      } else {
        model.addAttribute("noteFailure", true);
      }
    } else {
      int updatedRows = notesService.updateNote(newNote);
      if (updatedRows == 1) {
        model.addAttribute("noteSuccess", true);
      } else {
        model.addAttribute("noteFailure", true);
      }
    }
    return "result";
  }

  @GetMapping("/note/delete")
  public String deleteNote(@RequestParam(value = "noteid") Integer noteid, Model model) {
    int deletedRows = notesService.deleteNote(noteid);

    if (deletedRows == 1) {
      model.addAttribute("noteSuccess", true);
    } else {
      model.addAttribute("noteFailure", true);
    }
    return "result";
  }
  //################ End of Notes Operations ##############
  //################ Start of Credentials Operations ##############

  @PostMapping("/credentialToAdd")
  public String handleCredential(@ModelAttribute("credentialToAdd")SuperDuperCredentials credential,Principal principal, Model model){
    SuperDuperCredentials newCredential = new SuperDuperCredentials(credential.getCredentialId(),
        usersService.getUser(principal.getName()).getUserid(),credential.getUrl(), credential.getUsername(),
        credential.getKey(), credential.getPassword());

    if(credential.getCredentialId() == null){
      int rowsAdded = credentialService.insertNewCred(newCredential);
      if(rowsAdded == 1){
        model.addAttribute("credentialSuccess", true);
      } else {
        model.addAttribute("credentialFailure", true);
      }
      return "result";
    } else {
      int rowsUpdated = credentialService.updateCredential(newCredential);
      if(rowsUpdated == 1){
        model.addAttribute("credentialSuccess", true);
      } else {
        model.addAttribute("credentialFailure", true);
      }
      return "result";
    }
  }

  @GetMapping("/credential/delete")
  public String deleteCredential(@RequestParam(value = "credid") Integer credid, Model model){
    int deleteRows = credentialService.deleteCredential(credid);

    if (deleteRows == 1){
      model.addAttribute("credentialSuccess", true);
    }else{
      model.addAttribute("credentialFailure", true);
    }
    return "result";
  }
}