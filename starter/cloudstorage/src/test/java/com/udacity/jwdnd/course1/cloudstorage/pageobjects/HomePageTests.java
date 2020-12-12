package com.udacity.jwdnd.course1.cloudstorage.pageobjects;
// @author asmaa **


import java.lang.management.ThreadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jdk.dynalink.linker.LinkerServices;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageTests {
  @FindBy(css = ".btn.btn-secondary")
  private WebElement logoutBtn;
  @FindBy(id = "nav-notes-tab")
  private WebElement notesTab;
  @FindBy(id = "add-Note")
  private WebElement addNoteBtn;
  @FindBy(id = "note-title")
  private WebElement noteTitle;
  @FindBy(id = "note-description")
  private WebElement noteDescription;
  @FindBy(id = "notes-save")
  private WebElement noteSave;


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
}
