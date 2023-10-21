package testcases;

import org.testng.annotations.Test;

import core.Page;

public class ShopTest extends Page
{
  @Test
  public void shoptest() 
  {
	 System.out.println("@Test - Shoptest"); 
  }
  @Test(dependsOnMethods = "shoptest")
  public void makepayment()
  {
	  System.out.println("@Test - makepayment");  
  }
}
