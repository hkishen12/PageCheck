package com.suiteCategory;


import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import Util.CategoryUtil;
import Util.TestUtil;

public class TestCase_FolderAndCategorySearch extends TestBase
{

	// Runmode of test case in a suite
	@BeforeTest
	public void checkTestSkip() throws Exception
	{	 
		TestUtil.checkTestSkip("CategoriesSuite","TestCase_FolderAndCategorySearch");
	}	 


	@Test
	public void verifyFolderAndCategorySearch() throws InterruptedException{
		CategoryUtil.ClickOnCategoryTab();
		CategoryUtil.checkSearch("CATEGORIES");
	}
	@AfterMethod 
	public void DefaultResult(ITestResult result) throws InterruptedException {
		System.out.println("Method name: " + result.getMethod().getMethodName());
		System.out.println("Success %:" + result.isSuccess());
		if(!result.isSuccess()){
			TestUtil.takeScreenShot(result.getMethod().getMethodName()+"_"+CONFIG.getProperty("QS_CreateQSFolderName"));
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