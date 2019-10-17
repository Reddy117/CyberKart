package com.demokart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demokart.pages.HomePage;
import com.demokart.pages.LandPage;
import com.demokart.utils.BaseClass;

public class LoginPageTest extends BaseClass{
	LandPage lp;
	HomePage hp;
	@BeforeMethod
	public void openApp(){
		initialize("chrome");
		lp=new LandPage();
		hp=new HomePage();
	}
	
	@Test
	public void verifyLandPageTitle(){
		String title=lp.getPageTitle();
		Assert.assertEquals(title, "My Store");
	}
	
	@Test
	public void verifyLogin(){
		lp.login(p.getProperty("uName"), p.getProperty("pWord"));
		String txt=hp.getEleText(hp.myAcc);
		Assert.assertEquals(txt, "MY ACCOUNT");
	}
	
	@AfterMethod
	public void tearDown(){
		hp.logOut();
	}
}
