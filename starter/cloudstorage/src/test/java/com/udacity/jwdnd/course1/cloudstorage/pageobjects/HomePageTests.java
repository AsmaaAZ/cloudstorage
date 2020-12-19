package com.udacity.jwdnd.course1.cloudstorage.pageobjects;
// @author asmaa **


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageTests {
  @FindBy(css = ".btn.btn-secondary")
  private WebElement logoutBtn;
  //@@@@@@@@@@@notes
  @FindBy(id = "nav-notes-tab")
  private WebElement notesTab;
  @FindBy(css = "#nav-notes > button:nth-child(1)")
  private WebElement addNoteBtn;
  @FindBy(id = "note-id")
  private WebElement noteId;
  @FindBy(id = "note-title")
  private WebElement noteTitle;
  @FindBy(id = "note-description")
  private WebElement noteDescription;
  @FindBy(id = "notes-save")
  private WebElement noteSaveBtn;
  @FindBy(css = ".btn-success")
  private WebElement editNoteBtn;
  @FindBy(css = "a.btn")
  private WebElement deleteNoteBtn;
  //@@@@@@@@@@credentials
  @FindBy(id = "nav-credentials-tab")
  private WebElement credentialTab;
  @FindBy(css = "#nav-credentials > button:nth-child(1)")
  private WebElement addCredentialBtn;
  @FindBy(id = "credential-url")
  private WebElement credUrl;
  @FindBy(id = "credential-username")
  private WebElement credUsername;
  @FindBy(id = "credential-password")
  private WebElement credPwd;
  @FindBy(css = "#credentialModal > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > button:nth-child(2)")
  private WebElement credSaveBtn;
  @FindBy(css = ".btn-success")
  private WebElement editCredBtn;
  @FindBy(id = "credential-save")
  private WebElement saveCredBtn;
  @FindBy(css = "a.btn.btn-danger")
  private WebElement deleteCredBtn;

  public HomePageTests(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public void logoutUser(WebDriver driver){
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    logoutBtn.click();
  }
  //############ Note Operations ###############
  public void addNote(WebDriver driver){
    notesTab.click();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    addNoteBtn.click();
    noteTitle.clear();
    noteDescription.clear();
    noteTitle.sendKeys("a note title");
    noteDescription.sendKeys("some description to make this note\n\n ..\n cool");
    noteSaveBtn.click();
    driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    ResultsPageTests rpt = new ResultsPageTests(driver);
    rpt.successRedirect(driver);
  }

  public void editNote(WebDriver driver){
    addNote(driver);
    notesTab.click();
    editNoteBtn.click();
    noteTitle.clear();
    noteTitle.sendKeys("an edited note title");
    noteSaveBtn.click();
    driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    ResultsPageTests rpt = new ResultsPageTests(driver);
    rpt.successRedirect(driver);
  }

  public void deleteNote(WebDriver driver){
    addNote(driver);
    addNote(driver);
    addNote(driver);
    notesTab.click();
    deleteNoteBtn.click();
    driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    ResultsPageTests rpt = new ResultsPageTests(driver);
    rpt.successRedirect(driver);
  }
//############ Credential Operations ###############
  public void createCredential(WebDriver driver){
    credentialTab.click();
    addCredentialBtn.click();
    credUrl.clear();
    credUsername.clear();
    credPwd.clear();
    credUrl.sendKeys("https://duckduckgo.com/");
    credUsername.sendKeys("DuckDuck");
    credPwd.sendKeys("Gooooo");
    credSaveBtn.click();

    ResultsPageTests rpt = new ResultsPageTests(driver);
    rpt.successRedirect(driver);
    credentialTab.click();
  }

  public boolean editCredential(WebDriver driver){
    createCredential(driver);
    editCredBtn.click();
    credUrl.clear();
    credUrl.sendKeys("https://twitter.com/");
    boolean isDecrypted = credPwd.getAttribute("value").equals("Gooooo");
    saveCredBtn.click();
    ResultsPageTests rpt = new ResultsPageTests(driver);
    rpt.successRedirect(driver);
    return isDecrypted;
  }

  public void deleteCredential(WebDriver driver){
    createCredential(driver);
    createCredential(driver);
    credentialTab.click();
    deleteCredBtn.click();
    driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    ResultsPageTests rpt = new ResultsPageTests(driver);
    rpt.successRedirect(driver);
  }
}
