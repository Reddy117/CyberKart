package com.demokart.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demokart.pages.HomePage;
import com.demokart.pages.KartPage;
import com.demokart.pages.LandPage;
import com.demokart.utils.BaseClass;

public class CartPageTest extends BaseClass{

	LandPage lp;
	HomePage hp;
	KartPage cp;
	@BeforeMethod
	public void openApp(){
		initialize("ff");
		
		lp=new LandPage();
		hp=new HomePage();
		cp=new KartPage();
	}
	
	@Test
	public void verifyTotalPriceOfkartProducts(){
		lp.login(p.getProperty("uName"), p.getProperty("pWord"));
		hp.addProductToKart(hp.womanLink, hp.tshirts, hp.tshirtxt, "2");
		cp.verifyTotal();
	}
}
