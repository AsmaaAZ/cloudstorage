package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.pageobjects.LoginPageTests;
import com.udacity.jwdnd.course1.cloudstorage.pageobjects.SignupPageTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

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
	public void getUnauthorizedResultPageTest(){
		driver.get("http://localhost:" + this.port + "/result");
		Assertions.assertNotEquals("Result", driver.getTitle());
	}

	//duplicate user not allowed test
	@Order(5)
	@Test
	public void duplicatedUsersTest(){
		SignupPageTests spt = new SignupPageTests(driver);
		spt.duplicateUser(driver, port);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-danger")));
		Assertions.assertEquals("Sign Up", driver.getTitle());
	}

	//sign up, login, logout & verify logout
	@Order(6)
	@Test
	public void doSignupLoginLogoutTest(){
		driver.get("http://localhost:" + port + "/login");
		LoginPageTests lpt = new LoginPageTests(driver);
		WebDriverWait wait = new WebDriverWait(driver,5);
		lpt.loginSignupLoginLogoutProcess(driver,port);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-dark")));
		driver.get("http://localhost:" + port + "/home");
		Assertions.assertEquals("Login", driver.getTitle());
	}

	@Order(7)
	@Test
	public void doNotesOperations(){
		driver.get("http://localhost:" + port + "/login");
		LoginPageTests lpt = new LoginPageTests(driver);
		lpt.notesLogin(driver, port);



		Assertions.assertEquals("Home", driver.getTitle());
	}
}
