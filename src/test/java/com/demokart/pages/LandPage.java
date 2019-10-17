package com.demokart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demokart.utils.BaseClass;

public class LandPage extends BaseClass{

	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	public WebElement signInlink;
	
	@FindBy(xpath="//*[@id=\"email\"]")
	public WebElement emailtxt;
	
	@FindBy(xpath="//*[@id=\"passwd\"]")
	public WebElement passtxt;
	
	@FindBy(xpath="//*[@id=\"SubmitLogin\"]")
	public WebElement signBtn;
	
	public LandPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void login(String uName,String password){
		try{
			signInlink.click();
			emailtxt.sendKeys(uName);
			passtxt.sendKeys(password);
			signBtn.click();
		}catch(Exception e){
			
		}
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
}
