package com.qa.springbootZPC.Test.Selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	@FindBy(id = "searchBox")
	private WebElement searchBox;
	
	@FindBy(id = "loginDropDown")
	private WebElement loginDropDown;
	
	@FindBy(id = "userNameInput")
	private WebElement userNameInput;
	
	@FindBy(id = "passWordInput")
	private WebElement passWordInput;
	
	@FindBy(id = "loginButton")
	private WebElement loginButton;
	
	@FindBy(id = "aboutUsLocation")
	private WebElement aboutUsLink;
	
	@FindBy(id = "aboutUsTitle")
	private WebElement aboutUsTitle;
	
	@FindBy(id = "coolerTab")
	private WebElement coolerTab;
	
	public void searchboxSelect() {
		searchBox.click();
	}
	
	public void searchFor(String input) {
		
		searchBox.clear();
		searchBox.sendKeys(input,Keys.RETURN);
		
	}
	
	public void viewAboutUsPage() {
		
		aboutUsLink.click();

	}
	
	public void viewCoolers() {
		
		coolerTab.click();

	}
	
	public String viewAboutUsInfo(WebDriver driver) {
		WebElement waitForviewAboutUsInfo = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.id("aboutUsTitle")));
		return aboutUsTitle.getAttribute("innerText");
	}
	
	
	public void Login(String userName,String passWord) {
		
		loginDropDown.click();
		
		userNameInput.click();
		userNameInput.sendKeys(userName);
		
		passWordInput.click();
		passWordInput.sendKeys(userName);
		
		loginButton.click();
		
	}
	
}
	

