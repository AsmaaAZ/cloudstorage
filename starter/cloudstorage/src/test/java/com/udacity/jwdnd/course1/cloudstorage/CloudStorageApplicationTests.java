package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.pageobjects.HomePageTests;
import com.udacity.jwdnd.course1.cloudstorage.pageobjects.LoginPageTests;
import com.udacity.jwdnd.course1.cloudstorage.pageobjects.SignupPageTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CloudStorageApplicationTests {

  @LocalServerPort
  private int port;

  private WebDriver driver;

  @BeforeAll
  static void beforeAll() {
    WebDriverManager.firefoxdriver().setup();
  }

  @BeforeEach
  public void beforeEach() {
    this.driver = new FirefoxDriver();
  }

  @AfterEach
  public void afterEach() {
    if (this.driver != null) {
      driver.quit();
    }
  }

  //Test permit
  @Order(1)
  @Test
  public void getLoginPageTest() {
    driver.get("http://localhost:" + this.port + "/login");
    Assertions.assertEquals("Login", driver.getTitle());
  }

  //Test permit
  @Order(2)
  @Test
  public void getSignupPageTest() {
    driver.get("http://localhost:" + this.port + "/signup");
    Assertions.assertEquals("Sign Up", driver.getTitle());
  }

  //test unauthorized access
  @Order(3)
  @Test
  public void getUnauthorizedHomePageTest() {
    driver.get("http://localhost:" + this.port + "/home");
    Assertions.assertNotEquals("Home", driver.getTitle());
  }

  //test unauthorized access
  @Order(4)
  @Test
  public void getUnauthorizedResultPageTest() {
    driver.get("http://localhost:" + this.port + "/result");
    Assertions.assertNotEquals("Result", driver.getTitle());
  }

  //duplicate user not allowed test
  @Order(5)
  @Test
  public void duplicatedUsersTest() {
    SignupPageTests spt = new SignupPageTests(driver);
    spt.duplicateUser(driver, port);
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-danger")));
    Assertions.assertEquals("Sign Up", driver.getTitle());
  }

  //sign up, login, logout & verify logout
  @Order(6)
  @Test
  public void doSignupLoginLogoutTest() {
    driver.get("http://localhost:" + port + "/login");
    LoginPageTests lpt = new LoginPageTests(driver);
    WebDriverWait wait = new WebDriverWait(driver, 5);
    lpt.loginSignupLoginLogoutProcess(driver);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert")));
    driver.get("http://localhost:" + port + "/home");
    Assertions.assertEquals("Login", driver.getTitle());
  }

  //Create a note & verify it's displayed
  @Order(7)
  @Test
  public void notesCreationTest() {
    String noteTitle = "";
    driver.get("http://localhost:" + port + "/login");
    LoginPageTests lpt = new LoginPageTests(driver);
    lpt.notesLogin(driver, "create");
    HomePageTests hpt = new HomePageTests(driver);
    hpt.addNote(driver);
    driver.findElement(By.id("nav-notes-tab")).click();
    List<WebElement> rows = driver.findElements(
        By.cssSelector("#userTable > tbody:nth-child(2) > tr:nth-child(1) > th:nth-child(2)"));
    for (WebElement row : rows) {
      noteTitle = row.getText();
    }
    Assertions.assertEquals("a note title", noteTitle);
  }

  //Edit and existing note and verify the edit
  @Order(8)
  @Test
  public void notesEditTest() {
    String noteTitle = "";
    driver.get("http://localhost:" + port + "/login");
    LoginPageTests lpt = new LoginPageTests(driver);
    lpt.notesLogin(driver, "edit");
    HomePageTests hpt = new HomePageTests(driver);
    hpt.editNote(driver);
    driver.findElement(By.id("nav-notes-tab")).click();
    List<WebElement> rows = driver.findElements(
        By.cssSelector("#userTable > tbody:nth-child(2) > tr:nth-child(1) > th:nth-child(2)"));
    for (WebElement row : rows) {
      noteTitle = row.getText();
    }
    Assertions.assertEquals("an edited note title", noteTitle);
  }

  //Test to delete a note why is edited note showing? hmmm
  @Order(9)
  @Test
  public void noteDeletionTest() {
    driver.get("http://localhost:" + port + "/login");
    LoginPageTests lpt = new LoginPageTests(driver);
    lpt.notesLogin(driver, "delete");
    HomePageTests hpt = new HomePageTests(driver);
    hpt.deleteNote(driver);
    driver.findElement(By.id("nav-notes-tab")).click();
    List<WebElement> rows = driver.findElements(By.cssSelector("#userTable > tbody > tr"));
    Assertions.assertEquals(1, rows.size());
  }

  //Test creating credential and checking if password is encrypted
  @Order(10)
  @Test
  public void createCredentialTest() {
    driver.get("http://localhost:" + port + "/login");
    LoginPageTests lpt = new LoginPageTests(driver);
    lpt.credentialLogin(driver, "create");
    HomePageTests hpt = new HomePageTests(driver);
    hpt.createCredential(driver);

    String pwd = "Gooooo";
    String encryptedPwd = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();

    Assertions.assertNotEquals(pwd, encryptedPwd);
  }

  //test editing credentials, verify editing and making sure that the password is decrypted in the dialog
  @Order(11)
  @Test
  public void editCredentialTest() {
    String newUrl = "nothing";
    driver.get("http://localhost:" + port + "/login");
    LoginPageTests lpt = new LoginPageTests(driver);
    lpt.credentialLogin(driver, "edit");
    HomePageTests hpt = new HomePageTests(driver);
    boolean isDecrypted = hpt.editCredential(driver);
    if (isDecrypted) {
      newUrl = driver.findElement(By.cssSelector(
          "#credentialTable > tbody:nth-child(2) > tr:nth-child(1) > th:nth-child(2)"))
          .getAttribute("innerHTML");
    }
    Assertions.assertEquals("https://twitter.com/", newUrl);
  }

  //test deleting credential and verifying it has been deleted
  @Order(12)
  @Test
  public void deleteCredentialTest() {
    driver.get("http://localhost:" + port + "/login");
    LoginPageTests lpt = new LoginPageTests(driver);
    lpt.credentialLogin(driver, "delete");
    HomePageTests hpt = new HomePageTests(driver);
    hpt.deleteCredential(driver);
    driver.findElement(By.id("nav-credentials-tab")).click();
    List<WebElement> rows = driver.findElements(By.cssSelector("#credentialTable > tbody > tr"));
    Assertions.assertEquals(1, rows.size());
  }
}