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
  @FindBy(css = "#notes-save")
  private WebElement noteSave;
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

  public HomePageTests(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public void logoutUser(WebDriver driver){
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    logoutBtn.click();
  }

  public void addNote(WebDriver driver){
    notesTab.click();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    addNoteBtn.click();
    noteTitle.clear();
    noteDescription.clear();
    noteTitle.sendKeys("a note title");
    noteDescription.sendKeys("some description to make this note\n\n ..\n cool");
    noteSave.click();
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
    noteSave.click();
    driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    ResultsPageTests rpt = new ResultsPageTests(driver);
    rpt.successRedirect(driver);
  }

  public void deleteNote(WebDriver driver){
    addNote(driver);
    notesTab.click();
    deleteNoteBtn.click();
    driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    ResultsPageTests rpt = new ResultsPageTests(driver);
    rpt.successRedirect(driver);
  }

  public void credentialCreation(WebDriver driver){
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
}
