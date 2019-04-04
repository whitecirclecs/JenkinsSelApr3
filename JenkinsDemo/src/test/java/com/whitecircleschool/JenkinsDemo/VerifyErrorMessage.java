package com.whitecircleschool.JenkinsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyErrorMessage {

	public static void main(String[] args) {
		// 1) Open the browser
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//To maximize the window
		driver.manage().window().maximize();
		
		// 2) Navigate to the application
		driver.get("https://facebook.com");
		
		// 3) Enter an invalid username
		driver.findElement(By.id("email")).sendKeys("batman998877@gmail.com");
		
		// 4) Enter an invalid password
		driver.findElement(By.id("pass")).sendKeys("password");
		
		// 5) Click on Login button
		driver.findElement(By.id("loginbutton")).click();
		
		// 6) Verify the error message
		String expectedErrorMessage = "The email address that you've entered doesn't match any account. Sign up for an account.";
		String actualErrorMessage = driver.findElement(By.cssSelector("#globalContainer > div.uiContextualLayerPositioner._572t.uiLayer > div > div > div")).getText();
		
		if(expectedErrorMessage.equals(actualErrorMessage)) {
			System.out.println("Test Case Passed");
		}
		
		else {
			System.out.println("Test Case Failed");
		}
		
		driver.quit();
		
	
	}

}
