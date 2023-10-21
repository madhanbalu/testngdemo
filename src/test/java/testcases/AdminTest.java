package testcases;

import org.testng.annotations.Test;

import core.Page;

import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
import java.sql.SQLException;

import org.testng.annotations.DataProvider;

public class AdminTest extends Page
{
 @Test(dataProvider = "logindata",priority = 2)
  public void logintest(String uid, String pwd) 
  {
	  System.out.println("@Test -> logintest id "+uid+" pwd "+pwd+"");
  }
 // @Test(dataProvider = "signupdata" ,priority = 1)
  public void signuptest(String name,String age,String marks)
  {
	  System.out.println("@Test -> signuptest name "+name+" age "+age+" marks"+marks+"");
  }
  
  @DataProvider
  public Object[][] logindata() throws Exception 
  {
	  Object data[][]= {};  
   if (rs!= null) 
   {
	   ResultSetMetaData rsmt=rs.getMetaData();
	   	  int columncount=rsmt.getColumnCount();

	   	  rs.last(); // place record pointer on last record
	   	  int rowcount=rs.getRow(); // fetch position of last record

	   	  System.out.println(columncount+" , "+rowcount);
	   	  rs.beforeFirst(); // reset

	   	  data = new Object[rowcount][columncount]; //-> size of array , empty array
	   	  			
	   	  for(int rowNum = 1 ; rowNum <= rowcount ; rowNum++)
	   	     { 
	   	  				
	   	  for(int colNum=1 ; colNum<= columncount; colNum++)
	   	        {
	   	                   rs.absolute(rowNum); // point to row  
	   	  	Object data1= rs.getObject(colNum); // getting values from excel
	   	  	
	   	  		data[rowNum-1][colNum-1]= data1 ; //adding table data in  array , array starts from 0
	   	  				}
	   	  			}
	   	  }
	   	  
	   	  //System.out.println(data);
	   	  return data;

	     }

   
  
  
  @DataProvider
  public Object[][] signupdata() throws Exception
  {
	  Object data[][]= {};  
	   if (rs!= null) 
	   {
		   ResultSetMetaData rsmt=rs.getMetaData();
		   	  int columncount=rsmt.getColumnCount();

		   	  rs.last(); // place record pointer on last record
		   	  int rowcount=rs.getRow(); // fetch position of last record

		   	  System.out.println(columncount+" , "+rowcount);
		   	  rs.beforeFirst(); // reset

		   	  data = new Object[rowcount][columncount]; //-> size of array , empty array
		   	  			
		   	  for(int rowNum = 1 ; rowNum <= rowcount ; rowNum++)
		   	     { 
		   	  				
		   	  for(int colNum=1 ; colNum<= columncount; colNum++)
		   	        {
		   	                   rs.absolute(rowNum); // point to row  
		   	  	Object data1= rs.getObject(colNum); // getting values from excel
		   	  	
		   	  		data[rowNum-1][colNum-1]= data1 ; //adding table data in  array , array starts from 0
		   	  				}
		   	  			}
		   	  }
		   	  
		   	  //System.out.println(data);
		   	  return data;
  }
}
