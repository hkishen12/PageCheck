package com.SuiteCommon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Util.TestUtil;

public class TestCase_CheckExamTakers extends TestSuiteBase
{
	
// Runmode of test case in a suite
@BeforeTest
public void checkTestSkip() throws Exception
 {	 
	TestUtil.checkTestSkip("CommonSuite","TestCase_CheckExamTakers");
 }	 


@Test
public void CheckExamTakersTab() throws Exception
	{			
	
	WebElement Tabname = driver.findElement(By.linkText("Exam Takers"));
			//getObjectxpath("ExamTakers_xpath");
	String string = Tabname.getText();
	comparestringtext(string,"ExamTakers_string");
	
	}
@AfterMethod 
public void DefaultResult(ITestResult result) throws InterruptedException {
  System.out.println("Method name: " + result.getMethod().getMethodName());
  System.out.println("Success %:" + result.isSuccess());
  if(!result.isSuccess()){
	  TestUtil.takeScreenShot(result.getMethod().getMethodName());
	  closeBrowser();
	  System.out.println("Closing the Browser");
	  openBrowser();	
	  System.out.println("Opening the Browser");
	  TestUtil.doLogin();
	  System.out.println("Performed Login");
	
  }
  else{
	  System.out.println("Testcase is passed, Not required to call Exit!");  
	  
  }
}
	


}

