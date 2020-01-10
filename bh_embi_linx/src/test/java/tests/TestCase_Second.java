package tests;

import org.testng.annotations.Test;

import utils.Base;

public class TestCase_Second extends Base{

	
	
	@Test
	public void printInfo(){
		
		System.out.println("get current thread id of 2nd tc  "+Thread.currentThread().getId());
		System.out.println("This is second test case");
	}
	
	
	
	
	
}
