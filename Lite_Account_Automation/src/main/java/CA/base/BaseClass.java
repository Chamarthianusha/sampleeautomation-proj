package CA.base;

import CA.utilities.ExcelReader;
import CA.utilities.ExtentManager;
import CA.utilities.Utilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\com\\CA\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public static WebElement element;
	public static boolean acceptNextAlert;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;

	public static File folder;

	@BeforeTest
	@Parameters({ "browser" })
	public static void DesiredCapabilities (String browser) throws MalformedURLException, SQLException {

		try {
			fis = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\com\\CA\\properties\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			log.debug("Config file loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (browser.equalsIgnoreCase("firefox")) {

			System.out.println("Opening firefox driver");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("chrome")) {

			System.out.println("Opening chrome driver");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();

		} else if (browser.equalsIgnoreCase("ie")) {

			System.out.println("Opening IE driver");
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {

			System.out.println("Opening Edge driver");
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}

		driver.get(config.getProperty("testsiteurl"));
		log.debug("Navigated to : " + config.getProperty("testsiteurl"));
		driver.manage().timeouts().pageLoadTimeout(70L, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);

	}

	@AfterTest
	public static void quit() {

		driver.close();
		//driver.quit();
	}

	public static void scrollDownBYWebelemnt(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public static void scrollbyjavaexecutor(int X, int Y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(X,Y)", "");
	}

	// Common Keywords
	public static void click(String locator) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_LINKTEXT")) {
			driver.findElement(By.linkText(OR.getProperty(locator))).click();
		}
		log.debug("Clicking on an Element : " + locator);
		test.log(LogStatus.INFO, "Clicking on : " + locator);
	}

	public static void clear(String locator) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).clear();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).clear();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).clear();
		} else if (locator.endsWith("_LINKTEXT")) {
			driver.findElement(By.linkText(OR.getProperty(locator))).clear();
		}
		log.debug("clearing on an Element : " + locator);
		test.log(LogStatus.INFO, "clearing on : " + locator);
	}

	public static void type(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}

		log.debug("Typing in an Element : " + locator + " entered value as : " + value);

		test.log(LogStatus.INFO, "Typing in : " + locator + " entered value as " + value);

	}

	static WebElement dropdown;

	public static void select(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		}

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
		log.debug("Selecting from an element : " + locator + " value as : " + value);
		test.log(LogStatus.INFO, "Selecting from dropdown : " + locator + " value as " + value);

	}

	public static void selectbyindex(String locator, int index) {

		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		}

		Select select = new Select(dropdown);
		select.selectByIndex(index);
		log.debug("Selecting from an element : " + locator + " value as : " + index);
		test.log(LogStatus.INFO, "Selecting from dropdown : " + locator + " value as " + index);

	}

	public static boolean isElementPresent(By by) {

		try {

			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;

		}

	}

	public static void verifyEquals(String expected, String actual) throws IOException {

		try {

			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {

			Utilities.captureScreenshot();
			// ReportNG
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "><img src="
					+ Utilities.screenshotName + " height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			// Extent Reports
			test.log(LogStatus.FAIL, " Verification failed with exception : " + t.getMessage());
			test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));

		}

	}

	public static WebElement elementValue(String locator) {

		if (locator.endsWith("_CSS")) {
			WebElement element = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			WebElement element = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			WebElement element = driver.findElement(By.id(OR.getProperty(locator)));
		}
		log.debug("Selecting from an element : " + locator);
		test.log(LogStatus.INFO, "Selecting from dropdown : " + locator);

		return element;
	}

	public static String getText(String locator) {
		String resultString = null;
		if (locator.endsWith("_CSS")) {
			resultString = driver.findElement(By.cssSelector(OR.getProperty(locator))).getText();
		} else if (locator.endsWith("_XPATH")) {
			resultString = driver.findElement(By.xpath(OR.getProperty(locator))).getText();
		} else if (locator.endsWith("_ID")) {
			resultString = driver.findElement(By.id(OR.getProperty(locator))).getText();
		}
		log.debug("Text of the locator: " + locator + " value as :" + resultString);
		test.log(LogStatus.INFO, "Text of the locator : " + locator + " value as :" + resultString);
		return resultString;
	}

	public static String getAttributeValue(String locator, String value) {
		String resultString = null;
		if (locator.endsWith("_CSS")) {
			resultString = driver.findElement(By.cssSelector(OR.getProperty(locator))).getAttribute(value);
		} else if (locator.endsWith("_XPATH")) {
			resultString = driver.findElement(By.xpath(OR.getProperty(locator))).getAttribute(value);
		} else if (locator.endsWith("_ID")) {
			resultString = driver.findElement(By.id(OR.getProperty(locator))).getAttribute(value);
		}
		log.debug("Text of the locator: " + locator + " value as :" + resultString);
		test.log(LogStatus.INFO, "Text of the locator : " + locator + " value as :" + resultString);
		return resultString;
	}

// note : To check if element is visible we need to use element.isDisplayed(); But if we need to check for presence of element anywhere in Dom we can use following method

	public static boolean isElementPresentCheckUsingJavaScriptExecutor(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		try {
			Object obj = jse.executeScript("return typeof(arguments[0]) != 'undefined' && arguments[0] != null;",
					element);
			if (obj.toString().contains("true")) {
				System.out.println("isElementPresentCheckUsingJavaScriptExecutor: SUCCESS");
				return true;
			} else {
				System.out.println("isElementPresentCheckUsingJavaScriptExecutor: FAIL");
			}

		} catch (NoSuchElementException e) {
			System.out.println("isElementPresentCheckUsingJavaScriptExecutor: FAIL");
		}
		return false;
	}

	public static void highLightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}

	public static void iFrames(int frame) {
		driver.switchTo().frame(frame);
	}

	public void switchToNewWindow(int windowNumber) {
		Set<String> s = driver.getWindowHandles();
		Iterator<String> ite = s.iterator();
		int i = 1;
		while (ite.hasNext() && i < 10) {
			String popupHandle = ite.next().toString();
			driver.switchTo().window(popupHandle);
			System.out.println("Window title is : " + driver.getTitle());
			int windowCount = 0;
			if (i == windowCount)
				break;
			i++;
		}
	}

	public void switchToparentWindow() {
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());// returns all the windows

		driver.switchTo().window(windows.get(0));// Switch to parent window
		System.out.println("The window displaying is : " + driver.switchTo().window(windows.get(0)).getCurrentUrl());// Getting
																														// the
																														// URL
																														// of
																														// the
																														// current
																														// window
		// driver.close();
	}

	public static boolean isVisiable(String locator){
			try {
				if (locator.endsWith("_CSS")) {
					driver.findElement(By.cssSelector(OR.getProperty(locator))).isDisplayed();
				} else if (locator.endsWith("_XPATH")) {
					driver.findElement(By.xpath(OR.getProperty(locator))).isDisplayed();
				} else if (locator.endsWith("_ID")) {
					driver.findElement(By.id(OR.getProperty(locator))).isDisplayed();
				}
				log.debug("Clicking on an Element : "+locator);
				test.log(LogStatus.INFO, "Clicking on : " + locator);

				return true;
			}
			
			catch(Exception e) {
				return false;
			}
		}

	public static boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private static String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	public static void nevigation() {
		driver.navigate().back();

	}

	static WebElement act;

	public static void ClickActions(String locator) {

		if (locator.endsWith("_CSS")) {
			act = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			act = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			act = driver.findElement(By.id(OR.getProperty(locator)));
		}

		Actions action = new Actions(driver);
		action.moveToElement(act).click().build().perform();
		log.debug("Selecting from an element : " + locator);
		test.log(LogStatus.INFO, "Selecting from dropdown : " + locator);

	}
	
	public static void findelement(String locator) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator)));
		}

		log.debug("Finding the Element : " + locator);

		test.log(LogStatus.INFO, "Typing in : " + locator);

	}
	
	public static String getdefaultValuefromdropdown(String locator) {

		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		}

		Select select = new Select(dropdown);
		WebElement Option = select.getFirstSelectedOption();
		String defaultItem = Option.getText();
		log.debug("Fetching Default value from dropdown : " + locator + " value as : ");
		test.log(LogStatus.INFO, "Fetching Default value from dropdown : " + locator + " value as ");
		return defaultItem;
	}


}
