package flipkart.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import flipkartExcel.WriteExcel;
import io.qameta.allure.Step;

public class AutomateFlipkart 
{
	WebDriver driver;

	public AutomateFlipkart(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Enter email-id for login
	@FindBy(xpath = "//input[@class='_2zrpKA _1dBPDZ']")
	public WebElement emailId;

	//Enter password for login
	@FindBy(xpath = "//*[@type='password']")
	public WebElement pwd;

	//Click on login
	@FindBy(xpath = "//a[@class='_3Ep39l']")
	public WebElement login;

	//Click on login button
	@FindBy(xpath = "//*[@class='_2AkmmA _1LctnI _7UHT_c']")
	public WebElement loginBtn;

	//Locator for 'My Account' tab
	@FindBy(xpath = "//div[@class='_2aUbKa' and text()='My Account']")
	public WebElement myAccount;

	//To click on Logout
	@FindBy(xpath = "//div[@class='_1Q5BxB' and text()='Logout']")
	public WebElement logout;

	//To get the list of items present in cart and remove them
	@FindBy(xpath = "//div[@class='gdUKd9' and text()='Remove']")
	public List<WebElement> remove;

	//Click on refrigerator option
	@FindBy(xpath = "//a[@title='Double Door']")
	public WebElement fridge;

	//Click on first refrigerator option
	@FindBy(xpath = "//body/div[@id='container']/div/div/div/div/div/div[5]/div[1]/div[1]/div[1]/a[1]/div[2]/div[1]/div[1]")
	public WebElement fridgeOption;

	//Click on home appliances section
	@FindBy(xpath = "//span[text()='TVs & Appliances']")
	public WebElement homeAppliances;

	//Click on TV options
	@FindBy(xpath = "(//a[@title='LG'])[1]")
	public WebElement television;

	//Select televison item
	@FindBy(xpath = "//body/div[@id='container']/div/div/div/div/div/div[2]/div[1]/div[1]/div[1]/a[1]/div[2]/div[1]/div[1]")
	public WebElement tvOption;

	//Click on Air conditioners option
	@FindBy(xpath = "//a[text()='Inverter AC']")
	public WebElement airConditioner;

	//Select air conditioner item
	@FindBy(xpath = "//body/div[@id='container']/div/div/div/div/div/div[2]/div[1]/div[1]/div[1]/a[1]/div[2]/div[1]/div[1]")
	public WebElement acOption;

	//Add an item to cart
	@FindBy(css = "button._2AkmmA._2Npkh4._2MWPVK" )
	public WebElement addToCart;

	//Click on Cart option
	@FindBy(xpath = "//*[text()='Cart']")
	public WebElement cart;

	//Name of first item
	@FindBy(xpath = "//body//div[@id='container']//div//div//div[2]//div[1]//div[1]//div[1]//div[1]//a[1]")
	public WebElement nameFirstItem;

	//Price of first item
	@FindBy(xpath = "//body/div[@id='container']/div/div/div/div/div/div/div[2]/div[1]/div[1]/div[1]/span[1]")
	public WebElement priceFirstItem;

	//Name of second item
	@FindBy(xpath = "//div[3]//div[1]//div[1]//div[1]//div[1]//a[1]")
	public WebElement nameSecondItem;

	//Price of second item
	@FindBy(xpath = "//body/div[@id='container']/div/div/div/div/div/div/div[3]/div[1]/div[1]/div[1]/span[1]")
	public WebElement priceSecondItem;

	//Name of third item
	@FindBy(xpath = "//div[4]//div[1]//div[1]//div[1]//div[1]//a[1]")
	public WebElement nameThirdItem;

	//Price of third item
	@FindBy(xpath = "//body/div[@id='container']/div/div/div/div/div/div/div[4]/div[1]/div[1]/div[1]/span[1]")
	public WebElement priceThirdItem;

	//Total price of the cart
	@FindBy(css = "div.tnAu1u div.hJYgKM._2UO4l-")
	public WebElement totalCartPrice;

	//Remove button
	@FindBy(css = "#container>div>div._5wt5ag>div>div.ooJZfD._3FGKd2.col-12-12>div:nth-child(1)>div>div:nth-child(2)>div>div._3cto0P._2Mq1yq>div._3IO2ev._2K02N8._2x63a8>div:nth-child(2)")
	public WebElement removeBtn;

	//Pop up button for remove
	@FindBy(css = "#container>div>div._2ZtSUF._1xrsaD>div>div.row.LFy2Lc>div>div.gdUKd9._3Z4XMp._2nQDKB")
	public WebElement popupRemove;

	//Declare actions class
	Actions action ;

	@Step("To check whether email id field is enabled or not")
	public void checkEmailTab() throws IOException, Exception
	{
		//To load the properties file
		File file = new File("src\\main\\resources\\flipkart.properties");
		FileInputStream fis = new FileInputStream(file);

		Properties prop = new Properties();
		prop.load(fis);

		String driverType = prop.getProperty("driver");

		if(driverType.equalsIgnoreCase("InternetExplorer"))
		{
			login.click();
			Thread.sleep(2000);

			if(emailId.isEnabled())
			{
				System.out.println("The email id tab is enabled");
			}
			else
			{
				System.out.println("The email id tab is not enabled");
			}
		}
		else
		{
			if(emailId.isEnabled())
			{
				System.out.println("The email id tab is enabled");
			}
			else
			{
				System.out.println("The email id tab is not enabled");
			}
		}
	}

	@Step("To enter email id in the login field")
	public void enterMail(String email) throws Exception
	{
		emailId.sendKeys(email);
		Thread.sleep(1000);
	}

	@Step("To enter email id in the login field for negative test")
	public void enterMail_negativeTest(String email) throws Exception
	{
		emailId.sendKeys(email);
		Thread.sleep(2000);
	}

	@Step("To check whether password field is enabled or not")
	public void checkPassword()
	{
		if(pwd.isEnabled())
		{
			System.out.println("The password tab is enabled");
		}
		else
		{
			System.out.println("The password tab is not enabled");
		}
	}

	@Step("To enter password in the login field")
	public void enterPassword(String password) throws Exception
	{
		pwd.sendKeys(password);
		Thread.sleep(2000);
	}

	@Step("To enter password in the login field for negative test")
	public void enterPassword_negativeTest(String password) throws Exception
	{
		pwd.sendKeys(password);
		Thread.sleep(1000);
	}

	@Step("To check whether the login button is enabled or not")
	public void checkLoginBtn()
	{
		if(loginBtn.isEnabled())
		{
			System.out.println("The login button is enabled");
		}
		else
		{
			System.out.println("The login button is not enabled");
		}
	}

	@Step("To click on the login button")
	public void clickLogin() throws Exception
	{
		loginBtn.click();
		Thread.sleep(10000);
	}

	@Step("To click on the login button for negative test")
	public void login_NegativeTest() throws Exception
	{
		loginBtn.click();
		Thread.sleep(2000);
	}

	@Step("To check whether home appliances tab is enabled or not")
	public void checkHomeAppliances()
	{
		if(homeAppliances.isEnabled())
		{
			System.out.println("Home appliances tab is enabled");
		}
		else
		{
			System.out.println("Home appliances tab is not enabled");
		}
	}

	@Step("To hover to home appliances section")
	public void moveToHomeAppliances() throws Exception
	{
		action = new Actions(driver);
		action.moveToElement(homeAppliances).click().perform();
		Thread.sleep(3000);
	}

	@Step("To check whether refridgerator tab is enabled or not")
	public void checkOnFridges()
	{
		if(fridge.isEnabled())
		{
			System.out.println("The refridgerator section is enabled");
		}
		else
		{
			System.out.println("The refridgerator section is not enabled");
		}
	}

	@Step("To click on Refrigerator section")
	public void clickOnFridges() throws Exception
	{
		fridge.click();
		Thread.sleep(6000);
	}

	@Step("To click on first item")
	public void clickOnFirstItem() throws Exception 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", fridgeOption);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", fridgeOption);
		Thread.sleep(5000);
	}

	@Step("Add first item to cart") 
	public void addFirstItem() throws Exception
	{
		String MainWindow1=driver.getWindowHandle();

		// To handle all new opened window.				
		Set<String> s1=driver.getWindowHandles();		
		Iterator<String> i1=s1.iterator();

		while(i1.hasNext())			
		{		
			String ChildWindow1=i1.next();		

			if(!MainWindow1.equalsIgnoreCase(ChildWindow1))			
			{    		

				// Switching to Child window
				driver.switchTo().window(ChildWindow1);	

				//Add item to cart
				if(addToCart.isEnabled())
				{
					action = new Actions(driver);
					action.moveToElement(addToCart).click().perform();
					Thread.sleep(5000);
				}
				else
				{
					System.out.println("The selected element (first item) cannot be added to cart");
				}
				driver.close();
			}
		}
		driver.switchTo().window(MainWindow1);
		driver.navigate().back();
		Thread.sleep(8000);
	}

	@Step("To hover to home appliances section")
	public void moveToHomeAppliances1() throws Exception
	{

		action = new Actions(driver);
		action.moveToElement(homeAppliances).click().perform();

		Thread.sleep(3000);
	}

	@Step("To check whether television section is enabled or not")
	public void checkOnTV()
	{
		if(television.isEnabled())
		{
			System.out.println("Television section is enabled");
		}
		else
		{
			System.out.println("Television section is not enabled");
		}
	}

	@Step("To click on Television section")
	public void clickOnTV() throws Exception
	{
		television.click();
		Thread.sleep(5000);
	}

	@Step("To click on second item")
	public void clickOnSecondItem() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", tvOption);
		js.executeScript("arguments[0].click();", tvOption);
		Thread.sleep(5000);
	}

	@Step("Add second item to cart")
	public void addSecondItem() throws Exception
	{
		String MainWindow2=driver.getWindowHandle();

		// To handle all new opened window.				
		Set<String> s2=driver.getWindowHandles();		
		Iterator<String> i2=s2.iterator();

		while(i2.hasNext())			
		{		
			String ChildWindow2=i2.next();		

			if(!MainWindow2.equalsIgnoreCase(ChildWindow2))			
			{    		

				// Switching to Child window
				driver.switchTo().window(ChildWindow2);

				//Add item to cart
				if(addToCart.isEnabled())
				{
					action = new Actions(driver);
					action.moveToElement(addToCart).click().perform();
					Thread.sleep(5000);
				}
				else
				{
					System.out.println("The selected element (second item) cannot be added to cart");
				}
				driver.close();
			}
		}
		driver.switchTo().window(MainWindow2);
		driver.navigate().back();
		Thread.sleep(8000);
	}

	@Step("To display the values of first two items in cart")
	public void getData1() throws Exception
	{
		String itemName1_initial = nameFirstItem.getText();
		String itemPrice1_initial = priceFirstItem.getText();
		String itemName2_initial = nameSecondItem.getText();
		String itemPrice2_initial = priceSecondItem.getText();
		String totalPrice_initial = totalCartPrice.getText();
		WriteExcel write = new WriteExcel();
		write.getValues1(itemName1_initial, itemPrice1_initial, itemName2_initial, itemPrice2_initial, totalPrice_initial);
		Thread.sleep(5000);
		System.out.println(itemName1_initial);
		System.out.println(itemPrice1_initial);
		System.out.println(itemName2_initial);
		System.out.println(itemPrice2_initial);
		System.out.println(totalPrice_initial);
		driver.navigate().back();
		Thread.sleep(8000);
	}


	@Step("To hover to home appliances section")
	public void moveToHomeAppliances2() throws Exception
	{
		action = new Actions(driver);
		action.moveToElement(homeAppliances).click().perform();
		Thread.sleep(2000);
	}

	@Step("To check whether air conditioners section is enabled or not")
	public void checkOnAC()
	{
		if(airConditioner.isEnabled())
		{
			System.out.println("Air conditioners tab is enabled");
		}
		else
		{
			System.out.println("Air conditioners tab is not enabled");
		}
	}

	@Step("To click on air conditioners section")
	public void clickOnAC() throws Exception
	{
		action = new Actions(driver);
		action.moveToElement(airConditioner).click().perform();
		Thread.sleep(5000);
	}

	@Step("To click on third item")
	public void clickOnThirdItem() throws Exception
	{
		action = new Actions(driver);
		action.moveToElement(acOption).click().perform();
		Thread.sleep(3000);
	}

	@Step("Add third item to cart")
	public void addThirdItem() throws Exception
	{
		String MainWindow3=driver.getWindowHandle();

		// To handle all new opened window.				
		Set<String> s3=driver.getWindowHandles();		
		Iterator<String> i3=s3.iterator();

		while(i3.hasNext())
		{
			String ChildWindow3 = i3.next();

			if(!MainWindow3.equalsIgnoreCase(ChildWindow3))
			{
				// Switching to Child window
				driver.switchTo().window(ChildWindow3);

				//Add item to cart
				if(addToCart.isEnabled())
				{
					action = new Actions(driver);
					action.moveToElement(addToCart).click().perform();
					Thread.sleep(4000);
				}
				else
				{
					System.out.println("The selected element (third item) cannot be added to cart");
				}
				driver.close();
			}
		}
		driver.switchTo().window(MainWindow3);
		driver.navigate().back();
		Thread.sleep(8000);
	}

	@Step("To check whether cart is enabled or not")
	public void checkCart()
	{
		if(cart.isEnabled())
		{
			System.out.println("Cart is enabled");
		}
		else
		{
			System.out.println("Cart is not enabled");
		}
	}

	@Step("Click on cart icon")
	public void moveToCart() throws Exception
	{
		action = new Actions(driver);
		action.moveToElement(cart).click().perform();
		Thread.sleep(10000);
	}

	@Step("To take a screenshot")
	public String screenshot(WebDriver driver) throws IOException, Exception
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot ScrObj = (TakesScreenshot) driver;
		File CaptureImg = ScrObj.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(CaptureImg, new File("C:\\Users\\user\\eclipse-Mainak\\flipkart.com\\CaptureImages\\"+timeStamp+"_capture.jpg"));
		String path = "C:\\Users\\user\\eclipse-Mainak\\flipkart.com\\CaptureImages\\"+timeStamp+"_capture.jpg";
		Thread.sleep(10000);
		return path;
	}

	@Step("To take a screenshot for negative testing")
	public String screenshot_NegativeTest(WebDriver driver) throws IOException, Exception
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot ScrObj = (TakesScreenshot) driver;
		File CaptureImg = ScrObj.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(CaptureImg, new File("C:\\Users\\user\\eclipse-Mainak\\flipkart.com\\ErrorImages\\"+timeStamp+"_error.jpg"));
		String path = "C:\\Users\\user\\eclipse-Mainak\\flipkart.com\\ErrorImages\\"+timeStamp+"_error.jpg";
		Thread.sleep(3000);
		return path;
	}

	@Step("To write data in an excel sheet")
	public void getData() throws IOException
	{
		String itemName1 = nameFirstItem.getText();
		String itemPrice1 = priceFirstItem.getText();
		String itemName2 = nameSecondItem.getText();
		String itemPrice2 = priceSecondItem.getText();
		String itemName3 = nameThirdItem.getText();
		String itemPrice3 = priceThirdItem.getText();
		String updatdedTotalPrice = totalCartPrice.getText();

		System.out.println(itemName1);
		System.out.println(itemPrice1);
		System.out.println(itemName2);
		System.out.println(itemPrice2);
		System.out.println(itemName3);
		System.out.println(itemPrice3);
		System.out.println(updatdedTotalPrice);

		WriteExcel write = new WriteExcel();
		write.getValues2(itemName1, itemPrice1, itemName2, itemPrice2, itemName3, itemPrice3, updatdedTotalPrice);
	}

	@Step("To remove items from the cart")
	public void removeItems() throws Exception
	{
		int count = remove.size();
		System.out.println(count);
		for(int i=0;i<count;i++) {
			if(removeBtn.isDisplayed()) 
			{
				removeBtn.click();
				Thread.sleep(2000);
				popupRemove.click();
				Thread.sleep(5000);
			}
		}
		driver.navigate().back();
		Thread.sleep(6000);
	}

	@Step("To check whether My Account tab is enabled or not")
	public void checkMyAccount()
	{
		if(myAccount.isEnabled())
		{
			System.out.println("My Account tab is active and enabled");
		}
		else
		{
			System.out.println("My Account tab is inactive and not enabled");
		}
	}

	@Step("To logout from flipkart")
	public void logout() throws Exception
	{
		action = new Actions(driver);
		action.moveToElement(myAccount).build().perform();
		Thread.sleep(3000);
		action.moveToElement(logout).click().perform();
		Thread.sleep(5000);
	}
}




