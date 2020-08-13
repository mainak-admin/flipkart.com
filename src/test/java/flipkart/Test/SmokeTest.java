package flipkart.Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import flipkart.com.AutomateFlipkart;
import flipkart.com.WebDriverSetup;
import flipkartExcel.ReadExcel;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.annotations.BeforeTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class SmokeTest 
{
	WebDriver driver;
	Logger log = Logger.getLogger(SmokeTest.class);
	static AutomateFlipkart flipkart;
	static ReadExcel read;
	ExtentReports extent;
	ExtentTest Test;

	@BeforeTest(alwaysRun = true)
	public void setup_smokeTesting() 
	{
		try
		{
			WebDriverSetup d = new WebDriverSetup();
			driver = d.getDriver();
			log.info("**********************Logging into browser**********************");
			driver.manage().window().maximize();
			flipkart = new AutomateFlipkart(driver);
			read = new ReadExcel();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 0, description = "Checking email field before login", groups = "smoke")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: To check whether email field is enabled for smoke testing")
	public void checkEmailField_SmokeTest() 
	{
		try
		{
			extent = new ExtentReports("C:\\Users\\user\\eclipse-Mainak\\flipkart.com\\target\\surefire-reports\\Extent_SmokeReport.html", true);
			log.info("**********************Starting test cases**********************");
			log.info("**********************Verifying email tab**********************");
			Test = extent.startTest("Checking email field for smoke testing");
			Test.log(LogStatus.INFO, "Smoke test for checking email initiated");
			flipkart.checkEmailTab();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='3px solid green'", flipkart.emailId);
			Test.log(LogStatus.PASS, "Email tab is enabled for login");
			log.info("**********************Email tab verified**********************");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 1, description = "Entering email for login", groups = "smoke")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: To enter email for login")
	public void enterEmailForLogin_SmokeTest() 
	{
		try
		{
			Test = extent.startTest("Entering email for smoke testing");
			Test.log(LogStatus.INFO, "Smoke test for entering email initiated");
			log.info("**********************Entering mail for login**********************");
			flipkart.enterMail(read.readExcel()[0]);
			log.info("**********************Email id entered**********************");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	@Test(priority = 2, description = "Checking password field before login", groups = "smoke")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: To check whether password field is enabled for smoke testing")
	public void checkPassword_SmokeTest()
	{
		try
		{
			Test = extent.startTest("Checking password field for smoke testing");
			Test.log(LogStatus.INFO, "Smoke test for checking password initiated");
			log.info("**********************Verifying password tab**********************");
			flipkart.checkPassword();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='3px solid green'", flipkart.pwd);
			Test.log(LogStatus.PASS, "Password tab is enabled for login");
			log.info("**********************Password tab verified**********************");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 3, description = "Entering password for login", groups = "smoke")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: To enter password for login")
	public void enterPassword_smokeTesting()
	{
		try
		{
			Test = extent.startTest("Entering password for smoke testing");
			Test.log(LogStatus.INFO, "Smoke test for entering password initiated");
			log.info("**********************Entering password for login**********************");
			flipkart.enterPassword(read.readExcel()[1]);
			Test.log(LogStatus.PASS, "Password for login has been entered");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 4, description = "Verifying whether login button is enabled or not", groups = "smoke")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Verifying login button")
	public void checkLogin_SmokeTest()
	{
		try
		{
			Test = extent.startTest("Verifying login button for smoke testing");
			Test.log(LogStatus.INFO, "Smoke test for verifying login initiated");
			log.info("**********************Verifying login button**********************");
			flipkart.checkLoginBtn();
			log.info("**********************Login button verified**********************");
			Test.log(LogStatus.PASS, "Login button is enabled");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	@Test(priority = 5, description = "Click on login button", groups = "smoke")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Click on login button")
	public void clickOnLogin_smokeTesting()
	{
		try
		{
			Test = extent.startTest("Clicking on login button for smoke testing");
			Test.log(LogStatus.INFO, "Smoke test for login initiated");
			log.info("**********************Clicking on login button**********************");
			flipkart.clickLogin();
			Test.log(LogStatus.PASS, "Logging into website");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 6, description = "Verifying title of the page", groups = "smoke")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: To verify the title of the page")
	public void checkTitle_SmokeTest()
	{
		Test = extent.startTest("Verify webpage title for smoke testing");
		Test.log(LogStatus.INFO, "Smoke test for title verification initiated");
		String title = driver.getTitle();
		System.out.println(title);
		log.info("**********************Verifying page title**********************");
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		Test.log(LogStatus.PASS, "The title of webpage is verified");
	}

	@Test(priority = 7, description = "Verifying 'My Account' tab", groups = "smoke")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Verifying 'My Account' tab")
	public void checkAccount_SmokeTest()
	{
		try
		{
			Test = extent.startTest("Clicking on 'My Account' button for smoke testing");
			Test.log(LogStatus.INFO, "Smoke test for 'My Account' initiated");
			log.info("**********************Verifying 'My Account' button**********************");
			flipkart.checkMyAccount();
			log.info("**********************'My Account' button verified**********************");
			Test.log(LogStatus.PASS, "'My Account' tab is enabled");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 8, description = "Verifying Cart tab", groups = "smoke")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Verifying cart tab")
	public void checkCart_SmokeTest()
	{
		try
		{
			Test = extent.startTest("Clicking on Cart button for smoke testing");
			Test.log(LogStatus.INFO, "Smoke test for Cart initiated");
			log.info("**********************Verifying cart button**********************");
			flipkart.checkCart();
			log.info("**********************Cart button verified**********************");
			Test.log(LogStatus.PASS, "Cart button is enabled");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 9, description = "Verifying home appliances tab", groups = "smoke")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Verifying home appliances tab")
	public void checkHomeAppliances_SmokeTest()
	{
		try
		{
			Test = extent.startTest("Verifying home appliances tab for smoke testing");
			Test.log(LogStatus.INFO, "Smoke test for home appliances initiated");
			log.info("**********************Verifying home appliances tab**********************");
			flipkart.checkHomeAppliances();
			log.info("**********************Home appliances tab verified**********************");
			Test.log(LogStatus.PASS, "Home appliances tab is enabled");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 10, groups = "smoke")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: Click on home appliances section")
	public void homeAppliances_smokeTesting()
	{
		try
		{
			Test = extent.startTest("Click on home appliances for smoke testing");
			Test.log(LogStatus.INFO, "Smoke test for hovering to home appliances initiated");
			log.info("**********************Clicking on home appliances**********************");
			flipkart.moveToHomeAppliances();
			Test.log(LogStatus.PASS, "Clicked on home appliances");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	@Test(priority = 11, description = "Verifying refridgerator tab", groups = "smoke")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Verifying refridgerator tab")
	public void checkFridge_SmokeTest()
	{
		try
		{
			Test = extent.startTest("Verifying refridgerator tab for smoke testing");
			Test.log(LogStatus.INFO, "Smoke test for refridgerator initiated");
			log.info("**********************Verifying refridgerator tab**********************");
			flipkart.checkOnFridges();
			log.info("**********************Refridgerator tab verified**********************");
			Test.log(LogStatus.PASS, "Refridgerator tab is enabled");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 12, description = "Verifying television tab", groups = "smoke")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Verifying television tab")
	public void checkTV_SmokeTest()
	{
		try
		{
			Test = extent.startTest("Verifying television tab for smoke testing");
			Test.log(LogStatus.INFO, "Smoke test for television initiated");
			log.info("**********************Verifying television tab**********************");
			flipkart.checkOnTV();
			log.info("**********************Television tab verified**********************");
			Test.log(LogStatus.PASS, "Television tab is enabled");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 13, description = "Verifying air conditioner tab", groups = "smoke")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Verifying air conditioner tab")
	public void checkAC_SmokeTest()
	{
		try
		{
			Test = extent.startTest("Verifying air conditioner tab for smoke testing");
			Test.log(LogStatus.INFO, "Smoke test for air conditioner initiated");
			log.info("**********************Verifying air conditioner tab**********************");
			flipkart.checkOnAC();
			log.info("**********************Air conditioner tab verified**********************");
			Test.log(LogStatus.PASS, "Air conditioner tab is enabled");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 14, description = "To logout from flipkart", groups = "smoke")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: To logout from flipkart")
	public void logOut_SmokeTest()
	{
		try
		{
			Test = extent.startTest("Logging out from flipkart");
			Test.log(LogStatus.INFO, "Smoke test for logging out is generated");
			log.info("**********************Logging out from flipkart**********************");
			flipkart.logout();
			Test.log(LogStatus.PASS, "Logged out successfully !!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@AfterMethod(alwaysRun=true, groups ="smoke")
	public void flush(ITestResult result) {

		if(result.getStatus()==ITestResult.FAILURE) {
			Test.log(LogStatus.FAIL,"The test case "+result.getName()+" is failed");
			Test.log(LogStatus.FAIL, result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			Test.log(LogStatus.SKIP,"The test case "+result.getName()+" is skipped");
		}

		extent.endTest(Test);
		extent.flush();
	}

	@AfterTest(alwaysRun = true)
	public void closeBrowser_smokeTesting() 
	{
		log.info("**********************Closing driver**********************");
		driver.quit();
	}

}
