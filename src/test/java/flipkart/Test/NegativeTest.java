package flipkart.Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import flipkart.com.AutomateFlipkart;
import flipkart.com.WebDriverSetup;

import flipkartExcel.ReadExcelNegative;
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

public class NegativeTest 
{
	WebDriver driver;
	Logger log = Logger.getLogger(NegativeTest.class);
	static AutomateFlipkart flipkart;
	static ReadExcelNegative read;
	ExtentReports extent;
	ExtentTest Test;

	@BeforeTest(alwaysRun = true)
	public void setup_NegativeTest() 
	{
		try
		{
			WebDriverSetup d = new WebDriverSetup();
			driver = d.getDriver();
			log.info("**********************Logging into browser**********************");
			driver.manage().window().maximize();
			flipkart = new AutomateFlipkart(driver);
			read = new ReadExcelNegative();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 0, description = "Entering email for negative testing")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: To enter email for negative testing")
	public void enterEmailForLogin_NegativeTest() 
	{
		try
		{
			extent = new ExtentReports("C:\\Users\\user\\eclipse-Mainak\\flipkart.com\\target\\surefire-reports\\Extent_NegativeReport.html", true);
			Test = extent.startTest("Entering email for negative testing");
			Test.log(LogStatus.INFO, "Negative test for entering email initiated");
			log.info("**********************Entering e-mail for negative testing**********************");
			flipkart.enterMail_negativeTest(read.readExcelNegative()[0]);
			log.info("**********************Checking email for negative testing**********************");
			String text = flipkart.emailId.getAttribute("value");
			Assert.assertEquals(text, "dasmanindra63@gmail.com");
			Test.log(LogStatus.PASS, "Email for login has been entered");
			log.info("**********************An error has occured !**********************");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 1, description = "Entering password for negative testing")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: To enter password for negative testing")
	public void enterPassword_NegativeTest()
	{
		try
		{
			Test = extent.startTest("Entering password for negative testing");
			Test.log(LogStatus.INFO, "Negative test for entering password initiated");
			log.info("**********************Entering password for negative testing**********************");
			flipkart.enterPassword_negativeTest(read.readExcelNegative()[1]);
			log.info("**********************Checking email for negative testing**********************");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='3px solid red'", flipkart.pwd);
			String text = flipkart.pwd.getAttribute("value");
			Assert.assertEquals(text, "flipk@rt123");
			Test.log(LogStatus.PASS, "Password for login has been entered");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 2, description = "Click on login button")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Click on login button")
	public void clickOnLogin_NegativeTest()
	{
		try
		{
			Test = extent.startTest("Clicking on login button for negative testing");
			Test.log(LogStatus.INFO, "Negative test for login initiated");
			log.info("**********************Clicking on login button**********************");
			flipkart.login_NegativeTest();
			Test.log(LogStatus.PASS, "Logging into website");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 3, description = "To take a screenshot for negative test")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Screenshot to display the error message")
	public void screenshot_NegativeTest()
	{
		try
		{
			Test = extent.startTest("Preparing to take screenshot for negative test");
			Test.log(LogStatus.INFO, "Negative test for screenshot is generated");
			log.info("**********************Taking screenshot for negative test**********************");
			String imagePath = flipkart.screenshot_NegativeTest(driver);
			Test.log(LogStatus.PASS, "Screenshot has been taken");
			Test.log(LogStatus.PASS, Test.addScreenCapture(imagePath));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@AfterMethod(alwaysRun=true)
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
