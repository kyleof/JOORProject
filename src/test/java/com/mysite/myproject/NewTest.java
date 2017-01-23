package com.mysite.myproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

	
  @Test
  public class NewTest {

		
		@Test
		public void TestSendToAllWithImage()
		{
			NewPage x = new NewPage();
			x.logIn();
			x.clickMessageNavBar();
			x.clickSendAMessage();

			x.clickSelectAllConnections();

			x.enterSubject("test");
			x.enterMessage("Test12");
			
			x.attachImage();
	
			x.clickSend();
			
			x.logOut();
			
			x.quit();
		}
		
		@Test
		public void TestSendToAllWithoutImage()
		{
			NewPage x = new NewPage();
			x.logIn();
			x.clickMessageNavBar();
			x.clickSendAMessage();

			x.clickSelectAllConnections();

			x.enterSubject("test");
			x.enterMessage("Test12");
	
			x.clickSend();
			
			x.logOut();
			
			x.quit();
		}
		
		@Test
		public void SendToSelectRecipientsWithImage()
		{
			NewPage x = new NewPage();
			x.logIn();
			x.clickMessageNavBar();
			x.clickSendAMessage();
			
			x.clickSendToSelectConnections();
			x.waitForRecipients();
			
			//Testing the Send button when blank
			x.clickSend();
			x.closeAlertBox();
			
			x.enterKeysIntoRecipients("J");
			x.selectRecipients(1);
			x.enterKeysIntoRecipients("J");
			x.selectRecipients(2);
			x.enterKeysIntoRecipients("J");
			x.selectRecipients(3);
			x.enterSubject("test");
			x.enterMessage("Test12");
			
			x.attachImage();
	
			x.clickSend();
			
			x.logOut();
			
			x.quit();
		}
	    
		@Test
		public void SendToSelectRecipientsWithOutImage()
		{
			NewPage x = new NewPage();
			x.logIn();
			x.clickMessageNavBar();
			x.clickSendAMessage();
			
			x.clickSendToSelectConnections();
			x.waitForRecipients();
			
			//Testing the Send button when blank
			x.clickSend();
			x.closeAlertBox();
			

			x.enterKeysIntoRecipients("J");
			x.selectRecipients(1);
			x.enterKeysIntoRecipients("J");
			x.selectRecipients(2);
			x.enterKeysIntoRecipients("J");
			x.selectRecipients(3);
			x.enterSubject("test");
			x.enterMessage("Test12");
	
			x.clickSend();
			
			x.logOut();
			x.quit();
		}
		
  
}
