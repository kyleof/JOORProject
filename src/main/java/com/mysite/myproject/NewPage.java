package com.mysite.myproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPage{
	
	    private WebDriver driver;
	    private WebElement element;
	    private WebDriverWait wait;
	    
	    public NewPage()
	    {
	    	//constructor to initialise the drivers etc.
	    	driver = new ChromeDriver(); 
		    driver.get("http://staging.joordev.com"); 
		    wait = new WebDriverWait(driver,120);
	    }


	public void logIn()
	{
	  
	    driver.findElement(By.className("login-button")).click();
		
		driver.findElement(By.className("login-name")).sendKeys("qatest1");
		
		driver.findElement(By.className("login-pw")).sendKeys("qatest1");
		
		driver.findElement(By.className("gold-button")).click();
		

	}
	
	public void clickMessageNavBar() {
	
		driver.findElement(By.partialLinkText("Messages")).click();
	}	
	
	
	public void clickSendAMessage()
	{
		driver.findElement(By.partialLinkText("Send")).click();
	}
	
	
	public void enterAllRecipients()
	{
		driver.findElement(By.className("j-ac-recipients ui-autocomplete-input")).sendKeys("j");
		Select menu = new Select(driver.findElement(By.className("j-ac-recipients ui-autocomplete-input")));
		menu.selectByVisibleText("JOOR Regress ( JR112 ) - New York, NY");
	}
	
	//select all Connections
	public void clickSelectAllConnections()
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.id("MessageSendToAllConnections")));
		driver.findElement(By.id("MessageSendToAllConnections")).click();;
		
	}
	//Select specific connections 
	public void selectConnections()
	{
		driver.findElement(By.id("MessageSendToSelectConnections"));
	}
	//Input subject name on the Message dialog box 
	public void inputSubjectName(String subject)
	{
		String Subject = subject;
		driver.findElement(By.id("MessageSendToSelectConnections")).sendKeys(Subject);
	}

	//Input recipient name in the Message dialog box
	public void inputRecipient(String name)
	{
		String Name = name;
		driver.findElement(By.id("MessageSendToSelectConnections")).sendKeys();
	}


	public void clickSendToSelectConnections() {

		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("MessageSendToSelectConnections")));
		
		driver.findElement(By.id("MessageSendToSelectConnections")).click();
		
	}



	public void waitForRecipients() {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.className("j-ac-recipients")));
		
	}



	public void enterKeysIntoRecipients(String keys) {
		//Used to type into Recipients textbox to display the different options
		
		driver.findElement(By.className("j-ac-recipients")).sendKeys(keys);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.className("ui-corner-all")));
		
	}



	public void selectRecipients(int i) {
		
		//Used an ifelse to achieve the selection of the Recipients ranging from 1-3
		//SelectByVisibleText wasn't working for me so I used this as a workaround.
	
			if ( i == 1 )
			{
				driver.findElement(By.className("j-ac-recipients")).sendKeys(Keys.DOWN, Keys.RETURN);
			}
			
			else if (i == 2 )
			{
				driver.findElement(By.className("j-ac-recipients")).sendKeys(Keys.DOWN,Keys.DOWN, Keys.RETURN);
			}
			
			else if (i ==  3 )
			{
				driver.findElement(By.className("j-ac-recipients")).sendKeys(Keys.DOWN,Keys.DOWN,Keys.DOWN, Keys.RETURN);
			}
		
	}



	public void enterSubject(String string) {
		//Enter Subject 
		
		driver.findElement(By.className("no-submit")).sendKeys(string);
	}



	public void clickSend() {
		//click the send button on a message 
		wait.until(ExpectedConditions.elementToBeClickable(By.className("j-form-ajax-submit")));
		driver.findElement(By.className("j-form-ajax-submit")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}



	public void closeAlertBox() {
		//Closes the alert pop up in messages when an error has been made i.e no subject/message etc.
		driver.switchTo().alert().accept();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}



	public void enterMessage(String string) {
		//Enter text into the message box 
		driver.findElement(By.id("MessageBody")).sendKeys(string);
	}



	public void attachImage() {
		//Attach a default image using an absolute path
		driver.findElement(By.id("MessageAttachmentUpload")).sendKeys("/Users/Kyle/Documents/workspace3/myproject/testimage.png");
		
	}

	public void logOut() {
		
		//element was being blocked by the overlay so I have to use an action in order to click it
		
		WebElement element = driver.findElement(By.partialLinkText("Java"));

		Actions actions = new Actions(driver);

		actions.moveToElement(element).click().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Logout")));
		
		driver.findElement(By.partialLinkText("Logout")).click();
		
	}



	public void closeMessageBox() {
		//Close Message Dialog Box
		wait.until(ExpectedConditions.elementToBeClickable(By.className("j-popup-close")));
		
		driver.findElement(By.className("j-popup-close")).click();
	}
	
	public void quit()
	{
		driver.quit();
	}
}

