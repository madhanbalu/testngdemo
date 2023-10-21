package core;

//import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Page {
	
	public Connection con = null;
	public Statement stm = null;
	public ResultSet rs = null; 
	
  
 
  @BeforeMethod //3rd calling again & again
  public void openBrowser() 
  {
	  System.out.println("@BeforeMethod ->openBrowser");
  }

  @AfterMethod // 4th
  public void closeBrowser() 
  {
	  System.out.println("@AfterMethod -> closeBrowser");
  }

  @BeforeClass //2nd
  public void makeWBConnection(String wbname,String sheetname) throws Exception 
  {
	  //System.out.println("@BeforeClass -> makeWBConnection");
      System.out.println("@BeforeClass -> makeWBConnection wbname "+wbname);
	  
	  Class.forName("com.googlecode.sqlsheet.Driver"); // register excel driver 
	  String wbpath = System.getProperty("user.dir")+"//src//test//java//excel//Details.xlsx"+wbname;
	  con = DriverManager.getConnection("jdbc:xls:file:"+wbpath);
	  System.out.println("connected to excel WB..");
	  stm=con.createStatement();  // default top to bottom
	  rs=stm.executeQuery("select * from Sheet2 "); // Sheet name 

  }

  @AfterClass //5th
  public void closeWBConnection() throws Exception 
  {
	  System.out.println("@AfterClass -> closeWBConnection");
	  con.commit();
	  con.close();
  }

  @BeforeTest //1st
  public void generateLogReport() 
  {
	  System.out.println("@BeforeTest -> generateLogReport");
  }

  @AfterTest //6th
  public void closeReport() 
  {
	  System.out.println("@AfterTest -> closeReport");
  }

}
