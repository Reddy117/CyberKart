package com.demokart.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demokart.pages.HomePage;
import com.demokart.pages.LandPage;
import com.demokart.utils.BaseClass;

public class HomePageTest extends BaseClass{

	LandPage lp;
	HomePage hp;
	@BeforeMethod
	public void openApp(){
		initialize("ff");
		lp=new LandPage();
		hp=new HomePage();
	}
	
	@Test
	public void addProductToKartAndVerify(){
		lp.login(p.getProperty("uName"), p.getProperty("pWord"));
		hp.addProductToKart(hp.womanLink, hp.tshirts, hp.tshirtxt, "2");
	}
	
	@AfterMethod
	public void tearDown(){
		//hp.logOut();
	}
}
