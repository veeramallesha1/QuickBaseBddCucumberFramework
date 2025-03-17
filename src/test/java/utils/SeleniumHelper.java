package utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.paulhammant.ngwebdriver.NgWebDriver;

import org.openqa.selenium.JavascriptExecutor;


public class SeleniumHelper {
	
	public WebDriver driver;
	public NgWebDriver ngdriver;
	public static boolean cookie = false;

	public static Integer scriptTimeOut = 0;
	
	public SeleniumHelper(WebDriver driver) {
		this.driver = driver;

	}
	
	public SeleniumHelper waitTillElementToLoad(WebElement elem, double waitTime, int endTime) throws Exception {
        try {
            ExecutionTimer.startTimer();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(endTime));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            sleepWait(waitTime);
            if (elem.isDisplayed() == true) {
                sleepWait(waitTime);
                wait.until(ExpectedConditions.or(ExpectedConditions.invisibilityOf(elem)));
                waitForNGToLoad();
            }
            ExecutionTimer.endTimer();
            return new SeleniumHelper(driver);
        } catch (Exception e) {
            ExecutionTimer.endTimer();
            return new SeleniumHelper(driver);
        }
    }
	
	public SeleniumHelper sleepWait(double timeval) throws Exception {
		waitForNGToLoad();
		Double d = timeval * 1000;
		Integer intTime = d.intValue();
		Thread.sleep(intTime);
		waitForNGToLoad();
		return new SeleniumHelper(driver);
	}
	
	public SeleniumHelper waitForNGToLoad() throws Exception {
		ExecutionTimer.startTimer();
		ngdriver = new NgWebDriver((JavascriptExecutor) driver);
		ngdriver.waitForAngularRequestsToFinish();
		ExecutionTimer.endTimer();
		return new SeleniumHelper(driver);
	}
	public SeleniumHelper jsClick(WebElement elem) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		return new SeleniumHelper(driver);
	}
	public SeleniumHelper click(WebElement elem) throws Exception {
		waitForNGToLoad();
		elem.click();
		waitForNGToLoad();
		return new SeleniumHelper(driver);
	}
	
	public SeleniumHelper waitTillElementIsVisible(WebElement elem, int timeval) throws Exception {
		waitForNGToLoad();
		ExecutionTimer.startTimer();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeval));
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(elem)));
		ExecutionTimer.endTimer();
		waitForNGToLoad();
		return new SeleniumHelper(driver);
	}
	public SeleniumHelper sendKeysTo(WebElement elem, String str) throws Exception {
		waitForNGToLoad();
		elem.sendKeys(str);
		waitForNGToLoad();
		return new SeleniumHelper(driver);
	}
	

}