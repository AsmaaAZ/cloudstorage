package com.udacity.jwdnd.course1.cloudstorage.pageobjects;
// @author asmaa **


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageTests {
  @FindBy(id = "inputUsername")
  private WebElement inputUsername;
  @FindBy(id = "inputPassword")
  private WebElement inputPassword;
  @FindBy(css = ".btn.btn-primary")
  private WebElement subBtn;
  @FindBy(linkText = "here")
  private WebElement anchorHere;

  public LoginPageTests(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public void loginSignupLoginLogoutProcess(WebDriver driver) {
    inputUsername.clear();
    inputPassword.clear();

    inputUsername.sendKeys("a");
    inputPassword.sendKeys("a");
    subBtn.click();
    anchorHere.click();
    SignupPageTests toSignupPage = new SignupPageTests(driver);
    toSignupPage.registerForOperations(driver, "a","a","a","a");
    inputUsername.clear();
    inputPassword.clear();

    inputUsername.sendKeys("a");
    inputPassword.sendKeys("a");
    subBtn.click();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    HomePageTests hpt = new HomePageTests(driver);
    hpt.logoutUser(driver);
  }

  public void notesLogin(WebDriver driver, String notesFlag) {
    switch (notesFlag) {
      case "create": {
        inputUsername.clear();
        inputPassword.clear();

        inputUsername.sendKeys("b");
        inputPassword.sendKeys("b");
        subBtn.click();
        anchorHere.click();
        SignupPageTests spt = new SignupPageTests(driver);
        spt.registerForOperations(driver, "b", "b", "b", "b");
        inputUsername.clear();
        inputPassword.clear();

        inputUsername.sendKeys("b");
        inputPassword.sendKeys("b");
        subBtn.click();
        break;
      }
      case "edit": {
        inputUsername.clear();
        inputPassword.clear();

        inputUsername.sendKeys("NotEdit");
        inputPassword.sendKeys("NotEdit");
        subBtn.click();
        anchorHere.click();
        SignupPageTests spt = new SignupPageTests(driver);
        spt.registerForOperations(driver, "NotEdit", "NotEdit", "NotEdit", "NotEdit");
        inputUsername.clear();
        inputPassword.clear();

        inputUsername.sendKeys("NotEdit");
        inputPassword.sendKeys("NotEdit");
        subBtn.click();
        break;
      }
      case "delete": {
        inputUsername.clear();
        inputPassword.clear();

        inputUsername.sendKeys("notedel");
        inputPassword.sendKeys("notedel");
        subBtn.click();
        anchorHere.click();
        SignupPageTests spt = new SignupPageTests(driver);
        spt.registerForOperations(driver, "notedel", "notedel", "notedel", "notedel");
        inputUsername.clear();
        inputPassword.clear();

        inputUsername.sendKeys("notedel");
        inputPassword.sendKeys("notedel");
        subBtn.click();
        break;
      }
    }
  }

  public void credentialLogin(WebDriver driver, String credentialFlag) {
    switch (credentialFlag) {
      case "create": {
        inputUsername.clear();
        inputPassword.clear();

        inputUsername.sendKeys("c");
        inputPassword.sendKeys("c");
        subBtn.click();
        anchorHere.click();
        SignupPageTests spt = new SignupPageTests(driver);
        spt.registerForOperations(driver, "c", "c", "c", "c");
        inputUsername.clear();
        inputPassword.clear();

        inputUsername.sendKeys("c");
        inputPassword.sendKeys("c");
        subBtn.click();
        break;
      }
      case "edit": {
        inputUsername.clear();
        inputPassword.clear();

        inputUsername.sendKeys("credEdit");
        inputPassword.sendKeys("credEdit");
        subBtn.click();
        anchorHere.click();
        SignupPageTests spt = new SignupPageTests(driver);
        spt.registerForOperations(driver, "credEdit", "credEdit", "credEdit", "credEdit");
        inputUsername.clear();
        inputPassword.clear();

        inputUsername.sendKeys("credEdit");
        inputPassword.sendKeys("credEdit");
        subBtn.click();
        break;
      }
      case "delete": {
        inputUsername.clear();
        inputPassword.clear();

        inputUsername.sendKeys("credDel");
        inputPassword.sendKeys("credDel");
        subBtn.click();
        anchorHere.click();
        SignupPageTests spt = new SignupPageTests(driver);
        spt.registerForOperations(driver, "credDel", "credDel", "credDel", "credDel");
        inputUsername.clear();
        inputPassword.clear();

        inputUsername.sendKeys("credDel");
        inputPassword.sendKeys("credDel");
        subBtn.click();
        break;
      }
    }
  }
}
