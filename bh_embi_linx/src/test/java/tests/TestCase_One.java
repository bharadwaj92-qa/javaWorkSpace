package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.FirstPage;
import utils.Base;
import utils.ReadTestData;

public class TestCase_One extends Base{

	
	@DataProvider
	public Iterator<Object[]> getData() throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		List<Map<String,String>> lst = ReadTestData.getTestData();
		List<Object[]> lstRet = new ArrayList<Object[]>();
		for(Map<String,String> map:lst){
		lstRet.add(new Object[]{map});
		}
		System.out.println(lstRet.size());
		return lstRet.iterator();
		
	}
	
	@Test(dataProvider="getData")
	public void enterData(Map<String,String> data){
//		System.out.println(data.get("UserName"));
//		String temp=data.get("UserName");
//		System.out.println("temp value is"+temp);
//      WebElement search = driver.findElement(By.id(""));

		
//   FirstPage fp=new FirstPage();
   
   new FirstPage().enterTheData(data.get("UserName"));
		
	}
	
	
	
	
	
	
	
	
}
