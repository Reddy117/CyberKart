package com.demokart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.demokart.utils.BaseClass;

public class KartPage extends BaseClass{

	public KartPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
	public WebElement cartLink;
	
	@FindBy(xpath="//span[contains(text(),'In stock')]/following::span[1]")
	public WebElement unitPrice;
	
	@FindBy(xpath="//span[contains(text(),'In stock')]/following::span[5]")
	public WebElement totalPrice;
	
	public void verifyTotal(){
		
		cartLink.click();
		String unitprc=unitPrice.getText();
		String totalprc=totalPrice.getText();
		String unitpric=unitprc.substring(1);
		String totalPric=totalprc.substring(1);
		double actTotal=Double.parseDouble(unitpric)*2;
		Assert.assertEquals(actTotal, Double.parseDouble(totalPric));
		//System.out.println(actTotal);
	}
	
}
