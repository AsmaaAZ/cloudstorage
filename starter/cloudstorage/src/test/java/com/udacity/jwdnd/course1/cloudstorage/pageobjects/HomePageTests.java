package com.udacity.jwdnd.course1.cloudstorage.pageobjects;
// @author asmaa **


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageTests {
  @FindBy(css = ".btn.btn-secondary.float-right")
  private WebElement logoutBtn;

  public HomePageTests(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public void logoutUser(WebDriver driver){
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    logoutBtn.click();
  }
}
