package tests;

import org.testng.annotations.Test;

import utils.Base;

public class TestCase_Three extends Base{
	
	
	
	@Test
	public void enter(){
		
		System.out.println("get current thread id of 3rd tc   "+Thread.currentThread().getId());
		 
		System.out.println("This is third test case");
		
		
	}
	
	
	

}
