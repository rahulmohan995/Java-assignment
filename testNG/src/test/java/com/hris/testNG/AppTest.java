package com.hris.testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest 
    
{
   App test = new App();
   
   @Test
   public void testOpenHris()
   {
	   test.OpenHris();
	   Assert.assertTrue(test.CurrentLink().contains("hris.qainfotech.com/login.php"));
   }
   
   @Test(dependsOnMethods="testOpenHris")
   public void testValidLogin()
   {
	   test.Login("rahulmohan", "Rahul@321#");
	   Assert.assertTrue(test.CurrentLink().contains("timesheet"));
	   test.Logout();
	   
   }
   
   @Test(dependsOnMethods="testValidLogin")
   public void testBlankLogin()
   {
	   test.Login(" ", " ");
	   Assert.assertTrue(test.CurrentLink().contains("login"));
   }
   
   @Test(dependsOnMethods="testBlankLogin")
   public void testInvalidUsername()
   {
	   test.Login("qwerty", "Rahul@321");
	   Assert.assertTrue(test.CurrentLink().contains("login"));
   }
   
   @Test(dependsOnMethods="testInvalidUsername")
   public void testInvalidPassword()
   {
	   test.Login("rahulmohan", "asdfg12");
	   Assert.assertTrue(test.CurrentLink().contains("login"));
   }
   
   @Test(dependsOnMethods="testInvalidPassword")
   public void testUpperCaseUsername()
   {
	   test.Login("RAHULMOHAN", "Rahul@321#");
	   Assert.assertTrue(test.CurrentLink().contains("timesheet"));
	   test.Logout();
   }
   
   @Test(dependsOnMethods="testUpperCaseUsername")
   public void testDifferentCaseUser()
   {
	   test.Login("RaHulMoHaN", "Rahul@321#");
	   Assert.assertTrue(test.CurrentLink().contains("timesheet"));
	   test.Logout();
   }
   
   @Test(dependsOnMethods="testDifferentCaseUser")
   public void QuitBrowser()
   {
	   test.driver.quit();
   }
}
