package com.demokart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.demokart.utils.BaseClass;

public class HomePage extends BaseClass{
				
	@FindBy(xpath="//a[@title='Women']")
	public WebElement womanLink;
	
	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")
	public WebElement tshirts;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
	public WebElement tshirtxt;
	
	@FindBy(xpath="//*[@id=\"quantity_wanted\"]")
	public WebElement qtyTxt;
	
	@FindBy(xpath="//*[@id=\"group_1\"]")
	public WebElement sizeDrop;
	
	@FindBy(xpath="//*[@id=\"color_13\"]")
	public WebElement colorCheck;
	
	@FindBy(xpath="//*[@id=\"add_to_cart\"]/button/span")
	public WebElement addKartbtn;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/h1")
	public WebElement myAcc;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
	public WebElement logOutbtn;
	
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[1]/h2")
	public WebElement successmsg;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[1]/span")
	public WebElement closepopBtn;
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void addProductToKart(WebElement ele,WebElement ele1,WebElement ele2,String qty){
		try{
			Thread.sleep(5000);
			mouseHover(ele);
			//mouseHover(ele);
			Thread.sleep(1000);
			ele1.click();
			ele2.click();
			//driver.switchTo().frame(0);
			qtyTxt.clear();
			qtyTxt.sendKeys(qty);
			selectDrop(sizeDrop, "L");
			colorCheck.click();
			addKartbtn.click();
			getEleText(successmsg);
			//driver.switchTo().defaultContent();
			//Assert.assertEquals(getEleText(successmsg), "Product successfully added to your shopping cart");
			Thread.sleep(5000);
			closepopBtn.click();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public String getEleText(WebElement ele){
		return ele.getText();
	}
	
	public void logOut(){
		try{
			logOutbtn.click();
			driver.quit();
		}catch(Exception e){
			
		}
	}
}
