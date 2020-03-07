package com.usa.testNG;



import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgParameterExample {
	
	@Parameters(value="exampleDesc")
	@Test
	public void t1(String desc) {
		System.out.println("t1: " + desc);
	}

	@Parameters("exampleDesc")
	@Test
	public void t2(String desc) {
		System.out.println("t2: " + desc);
	}
}