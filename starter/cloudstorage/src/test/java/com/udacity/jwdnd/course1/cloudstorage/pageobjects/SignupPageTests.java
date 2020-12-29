package com.udacity.jwdnd.course1.cloudstorage.pageobjects;
// @author asmaa **


import java.util.concurrent.TimeUnit;
import org.apache.juli.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPageTests {
  @FindBy(id = "inputFirstName")
  private WebElement inputFirstName;
  @FindBy(id = "inputLastName")
  private WebElement inputLastName;
  @FindBy(id = "inputUsername")
  private WebElement inputUsername;
  @FindBy(id = "inputPassword")
  private WebElement inputPassword;
  @FindBy(css = ".btn.btn-primary")
  private WebElement subBtn;
  @FindBy(linkText = "login")
  private WebElement ancherLogin;

  public SignupPageTests(WebDriver driver) {
    PageFactory.initElements(driver,this);
  }

  public void registerForOperations(WebDriver driver, String fname, String lname, String uname, String pwd){
    inputFirstName.clear();
    inputLastName.clear();
    inputUsername.clear();
    inputPassword.clear();

    inputFirstName.sendKeys(fname);
    inputLastName.sendKeys(lname);
    inputUsername.sendKeys(uname);
    inputPassword.sendKeys(pwd);
    subBtn.click();
    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    ancherLogin.click();
  }

  public void duplicateUser(WebDriver driver, int port){
    driver.get("localhost:" + port + "/signup");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    inputFirstName.clear();
    inputLastName.clear();
    inputUsername.clear();
    inputPassword.clear();

    inputFirstName.sendKeys("asmaa");
    inputLastName.sendKeys("AZ");
    inputUsername.sendKeys("Azmeh");
    inputPassword.sendKeys("ha11");
    subBtn.click();
    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    inputFirstName.clear();
    inputLastName.clear();
    inputUsername.clear();
    inputPassword.clear();

    inputFirstName.sendKeys("asmaa");
    inputLastName.sendKeys("AZ");
    inputUsername.sendKeys("Azmeh");
    inputPassword.sendKeys("ha11");
    subBtn.click();
  }
}
