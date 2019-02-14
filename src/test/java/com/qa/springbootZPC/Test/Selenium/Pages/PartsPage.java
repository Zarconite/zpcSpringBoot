package com.qa.springbootZPC.Test.Selenium.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PartsPage {

	@FindBy(id = "searchBox")
	private WebElement searchBox;
	
	@FindBy(id = "ramTab")
	private WebElement ramTab;
	
	@FindBy(id = "basketButton1")
	private WebElement basketButton1;
	
	@FindBy(id = "basketTab")
	private WebElement basketTab;
	
	@FindBy(id = "passWordInput")
	private WebElement passWordInput;
	
	@FindBy(id = "loginButton")
	private WebElement loginButton;
	
	@FindBy(id = "aboutUs")
	private WebElement aboutUsLink;
	
	@FindBy(id = "result1Title")
	private WebElement result1Title;
	
	@FindBy(id = "result1Stock")
	private WebElement result1Stock;
	
	public void searchFor(String input) {
		
		searchBox.click();
		searchBox.sendKeys(input,Keys.RETURN);
		
	}
	
	public void addToBasket() {
		
		basketButton1.click();
		
	}
	
	public String getPart1Info() {
		
		return result1Title.getAttribute("innerText");
	}
	
	public String checkStock() {
		
		return result1Stock.getAttribute("innerText");
		
	}
	
}
	

