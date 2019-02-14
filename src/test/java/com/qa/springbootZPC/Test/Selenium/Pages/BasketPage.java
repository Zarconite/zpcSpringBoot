package com.qa.springbootZPC.Test.Selenium.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage {
	
	@FindBy(id = "basketTab")
	private WebElement basketTab;
	
	@FindBy(id = "basketItem1Header")
	private WebElement basketItem1Header;
	
	@FindBy(id = "basketItem2Header")
	private WebElement basketItem2Header;
	
	@FindBy(id = "basketItem1Price")
	private WebElement basketItem1Price;
	
	@FindBy(id = "basketItem2Price")
	private WebElement basketItem2Price;
	
	@FindBy(id = "basketTotalPrice")
	private WebElement basketTotalPrice;
	
	public void viewBasket() {
		
		basketTab.click();
		
	}
	
	public String checkBasketItem1() {
		
		return basketItem1Header.getAttribute("innerText");
		
	}
	
	public String checkBasketItem2() {
		
		return basketItem2Header.getAttribute("innerText");
		
	}
	
	public Double checkBasketItem1Price() {
		
		return Double.parseDouble(basketItem1Price.getAttribute("innerText").substring(1));
		
	}
	
	public Double checkBasketItem2Price() {
		
		return Double.parseDouble(basketItem2Price.getAttribute("innerText").substring(1));
		
	}
	
	public Double checkBasketPrice() {
		
		return Double.parseDouble(basketTotalPrice.getAttribute("innerText").substring(14));
		
	}
	
}
	

