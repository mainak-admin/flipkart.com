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

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class FlipkartTest {

	WebDriver driver;
	Logger log = Logger.getLogger(FlipkartTest.class);
	static AutomateFlipkart flipkart;
	static ReadExcel read;
	ExtentReports extent;
	ExtentTest Test;

	@BeforeTest(alwaysRun = true)
	public void setup()
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

	@Test(priority = 0, description = "Entering email for login", groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: To enter email for login")
	public void enterEmailForLogin() 
	{
		try
		{
			extent = new ExtentReports("C:\\Users\\user\\eclipse-Mainak\\flipkart.com\\target\\surefire-reports\\Extent_RegressionReport.html", true);
			Test = extent.startTest("Entering email for regression testing");
			Test.log(LogStatus.INFO, "Regression test for entering email initiated");
			log.info("**********************Starting test cases**********************");
			log.info("**********************Entering mail for login**********************");
			flipkart.enterMail(read.readExcel()[0]);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='3px solid green'", flipkart.emailId);
			Test.log(LogStatus.PASS, "Email for login has been entered");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	@Test(priority = 1, description = "Entering password for login", groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: To enter password for login")
	public void enterPasswordForLogin()
	{
		try
		{
			Test = extent.startTest("Entering password for regression testing");
			Test.log(LogStatus.INFO, "Regression test for entering password initiated");
			log.info("**********************Entering password for login**********************");
			flipkart.enterPassword(read.readExcel()[1]);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='3px solid green'", flipkart.pwd);
			Test.log(LogStatus.PASS, "Password for login has been entered");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 2, description = "Click on login button", groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Click on login button")
	public void clickOnLogin()
	{
		try
		{
			Test = extent.startTest("Clicking on login button for regression testing");
			Test.log(LogStatus.INFO, "Regression test for login initiated");
			log.info("**********************Clicking on login button**********************");
			flipkart.clickLogin();
			Test.log(LogStatus.PASS, "Logging into website");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 3, groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: To verify the title of the page")
	public void getTitle()
	{
		Test = extent.startTest("Verify webpage title for regression testing");
		Test.log(LogStatus.INFO, "Regression test for title verification initiated");
		String title = driver.getTitle();
		System.out.println(title);
		log.info("**********************Verifying page title**********************");
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		Test.log(LogStatus.PASS, "The title of webpage is verified");
	}

	@Test(priority = 4, groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: Click on home appliances section")
	public void homeAppliances()
	{
		try
		{
			Test = extent.startTest("Click on home appliances for regression testing");
			Test.log(LogStatus.INFO, "Regression test for hovering to home appliances initiated");
			log.info("**********************Clicking on home appliances**********************");
			flipkart.moveToHomeAppliances();
			Test.log(LogStatus.PASS, "Clicked on home appliances");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	@Test(priority = 5, groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: Click on refridgerator option")
	public void clickOnFridge()
	{
		try
		{
			Test = extent.startTest("Click on refridgerator option for regression testing");
			Test.log(LogStatus.INFO, "Regression test for clicking on refridgerator option initiated");
			log.info("**********************Clicking on refridgerator section**********************");
			flipkart.clickOnFridges();
			Test.log(LogStatus.PASS, "Clicked on refridgerator section");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 6, groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: Click on first item from refridgerator section")
	public void firstItem()
	{
		try
		{
			Test = extent.startTest("Click on first item");
			Test.log(LogStatus.INFO, "Regression test for clicking on first item initiated");
			log.info("**********************Selecting first item**********************");
			flipkart.clickOnFirstItem();
			Test.log(LogStatus.PASS, "Clicked on first item from refridgerator section");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 7, groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: Add first item to cart")
	public void addFirstItem()
	{
		try
		{
			Test = extent.startTest("Adding first item to cart");
			Test.log(LogStatus.INFO, "Regression test for adding to cart initiated");
			log.info("**********************Adding item to cart**********************");
			flipkart.addFirstItem();
			Test.log(LogStatus.PASS, "Added first item from refridgerator section");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 8, groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: Click on home appliances section")
	public void homeAppliances1()
	{
		try
		{
			Test = extent.startTest("Click on home appliances for regression testing");
			Test.log(LogStatus.INFO, "Regression test for hovering to home appliances initiated");
			log.info("**********************Clicking on home appliances**********************");
			flipkart.moveToHomeAppliances1();
			Test.log(LogStatus.PASS, "Clicked on home appliances");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 9, groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: Click on television section")
	public void clickOnTelevision()
	{
		try
		{
			Test = extent.startTest("Click on television option for regression testing");
			Test.log(LogStatus.INFO, "Regression test for clicking on television option initiated");
			log.info("**********************Clicking on television section**********************");
			flipkart.clickOnTV();
			Test.log(LogStatus.PASS, "Clicked on television section");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 10, groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: Click on second item from TV section")
	public void SecondItem()
	{
		try
		{
			Test = extent.startTest("Click on second item");
			Test.log(LogStatus.INFO, "Regression test for clicking on second item initiated");
			log.info("**********************Clicking on second item**********************");
			flipkart.clickOnSecondItem();
			Test.log(LogStatus.PASS, "Clicked on second item from television section");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 11, groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: Add second item to cart")
	public void addSecondItem()
	{
		try
		{
			Test = extent.startTest("Adding second item to cart");
			Test.log(LogStatus.INFO, "Regression test for adding to cart initiated");
			log.info("**********************Adding second item to cart**********************");
			flipkart.addSecondItem();
			Test.log(LogStatus.PASS, "Added second item from television section");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 12, groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: Click on cart to see the first two items")
	public void clickOnCart1()
	{
		try
		{
			Test = extent.startTest("Clicking on cart");
			Test.log(LogStatus.INFO, "Regression test for clicking on cart initiated");
			log.info("**********************Clicking on cart to check first two items**********************");
			flipkart.moveToCart();
			Test.log(LogStatus.PASS, "Clicked on cart to view first two items");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 13, groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: To take a initial screenshot of the items present in cart")
	public void screenshot_initial()
	{
		try
		{
			Test = extent.startTest("Preparing to take initial screenshot");
			Test.log(LogStatus.INFO, "Regression test for screenshot is generated");
			log.info("**********************Taking screenshot**********************");
			String imagePath = flipkart.screenshot(driver);
			Test.log(LogStatus.PASS, "Screenshot has been taken");
			Test.log(LogStatus.PASS, Test.addScreenCapture(imagePath));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 14, groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: To store the details of first two items in an excel sheet")
	public void writeDataInExcel1()
	{
		try
		{
			Test = extent.startTest("Storing details in excel file");
			Test.log(LogStatus.INFO, "Regression test for writing initial details is generated");
			log.info("**********************Storing values in excel**********************");
			flipkart.getData1();
			Test.log(LogStatus.PASS, "Data has been stored in excel file");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 15, groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: Click on home appliances section")
	public void homeAppliances2()
	{
		try
		{
			Test = extent.startTest("Click on home appliances for regression testing");
			Test.log(LogStatus.INFO, "Regression test for hovering to home appliances initiated");
			log.info("**********************Clicking on home appliances**********************");
			flipkart.moveToHomeAppliances2();
			Test.log(LogStatus.PASS, "Clicked on home appliances");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 16, groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: Click on air conditioners section")
	public void clickOnACtab()
	{
		try
		{
			Test = extent.startTest("Click on air conditioner option for regression testing");
			Test.log(LogStatus.INFO, "Regression test for clicking on air conditioner option initiated");
			log.info("**********************Clicking on air conditioner**********************");
			flipkart.clickOnAC();
			Test.log(LogStatus.PASS, "Clicked on air conditioners section");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 17, groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: Click on the third item")
	public void ThirdItem()
	{
		try
		{
			Test = extent.startTest("Click on third item");
			Test.log(LogStatus.INFO, "Regression test for clicking on third item initiated");
			log.info("**********************Clicking on the third item from AC section**********************");
			flipkart.clickOnThirdItem();

			Test.log(LogStatus.PASS, "Clicked on third item from air conditioner section");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	@Test(priority = 18, groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: Add third item to cart")
	public void addThirdItem()
	{
		try
		{
			Test = extent.startTest("Adding third item to cart");
			Test.log(LogStatus.INFO, "Regression test for adding to cart initiated");
			log.info("**********************Adding to cart**********************");
			flipkart.addThirdItem();
			Test.log(LogStatus.PASS, "Added third item from air conditioner section");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 19, groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: Click on cart to see the added items")
	public void clickOnCart2()
	{
		try
		{
			Test = extent.startTest("Click on cart to see added items");
			Test.log(LogStatus.INFO, "Regression test for clicking to cart initiated");
			log.info("**********************Clicking on cart**********************");
			flipkart.moveToCart();
			Test.log(LogStatus.PASS, "Clicked on cart section");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 20, groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: To take a screenshot of the items present in cart")
	public void screenshot_final()
	{
		try
		{
			Test = extent.startTest("Preparing to take final screenshot");
			Test.log(LogStatus.INFO, "Regression test for screenshot is generated");
			log.info("**********************Taking final screenshot**********************");
			String imagePath = flipkart.screenshot(driver);
			Test.log(LogStatus.PASS, "Screenshot has been taken");
			Test.log(LogStatus.PASS, Test.addScreenCapture(imagePath));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 21, groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: To write the data in an excel file")
	public void writeDataInExcel()
	{
		try
		{
			Test = extent.startTest("Storing details in excel file");
			Test.log(LogStatus.INFO, "Regression test for writing initial details is generated");
			log.info("**********************Writing in excel**********************");
			flipkart.getData();
			Test.log(LogStatus.PASS, "Data has been stored in excel file");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 22, groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: To remove items from cart")
	public void remove()
	{
		try
		{
			Test = extent.startTest("Remove the items from cart");
			Test.log(LogStatus.INFO, "Regression test for removing items from cart is generated");
			log.info("**********************Removing items from cart**********************");
			flipkart.removeItems();
			Test.log(LogStatus.PASS, "Cart has been cleared");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 23, groups = "regression")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: To logout from flipkart")
	public void logOut()
	{
		try
		{
			Test = extent.startTest("logging out from flipkart");
			Test.log(LogStatus.INFO, "Regression test for logging out is generated");
			log.info("**********************Logging out from flipkart**********************");
			flipkart.logout();
			Test.log(LogStatus.PASS, "Logged out successfully !!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@AfterMethod(alwaysRun=true, groups ="regression")
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
	public void closeDriver() 
	{
		log.info("**********************Closing driver**********************");
		driver.quit();
	}

}
