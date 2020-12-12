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
  private WebElement ancherHere;

  public LoginPageTests(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public void loginSignupLoginLogoutProcess(WebDriver driver, int port) {
    loginForOperations(driver);
    ancherHere.click();
    SignupPageTests toSignupPage = new SignupPageTests(driver);
    toSignupPage.registerForOperations(driver);
    loginForOperations(driver);
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    HomePageTests hpt = new HomePageTests(driver);
    hpt.logoutUser(driver);
  }

  public void notesLogin(WebDriver driver, int port){
    loginForOperations(driver);
    ancherHere.click();
    SignupPageTests spt = new SignupPageTests(driver);
    spt.registerForOperations(driver);
    loginForOperations(driver);
    HomePageTests hpt = new HomePageTests(driver);
    hpt.addNote(driver);
  }

  public void loginForOperations(WebDriver driver){
    inputUsername.clear();
    inputPassword.clear();

    inputUsername.sendKeys("Azmeh");
    inputPassword.sendKeys("ha11");
    subBtn.click();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

  }
}
