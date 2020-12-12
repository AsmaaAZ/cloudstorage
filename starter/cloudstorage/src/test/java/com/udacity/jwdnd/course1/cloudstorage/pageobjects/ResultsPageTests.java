package com.udacity.jwdnd.course1.cloudstorage.pageobjects;
// @author asmaa **


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPageTests {
  @FindBy(linkText = "here")
  private WebElement hereLink;

  private boolean operationDone;

  public ResultsPageTests(WebDriver driver){
    PageFactory.initElements(driver, this);
  }

  public void successRedirect(WebDriver driver){
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("here")));
    operationDone = true;
    hereLink.click();
  }

  public void failureRedirect(WebDriver driver, int port){
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("here")));
    operationDone = false;
    hereLink.click();
  }
}
