package com.ata.util;


import org.junit.Test;
/*
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

import com.wipro.ata.bean.CredentialsBean;
import com.wipro.ata.bean.ProfileBean;*/

/**
 * This test class is used to test the User methods.
 * @version 1.0
 * @author Abhinav , Abhilash
 */

public class TestUser {

/*	CredentialsBean credentialsBean= new CredentialsBean();
	UserImpl userImpl = new UserImpl();*/
	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	
	@Test
	public void testLogin() 
	{
		
		//String actual=null;
		
		/*credentialsBean=null;
		actual=userImpl.login(credentialsBean);
		assertEquals("FAIL", actual);*/
		
		
	/*	credentialsBean.setUserID("Ja1002");
		credentialsBean.setPassword("1234");
		actual=userImpl.login(credentialsBean);
		assertEquals("C", actual);*/
		
		/*credentialsBean.setUserID("Ab1000");
		credentialsBean.setPassword("123");
		actual=userImpl.login(credentialsBean);
		assertEquals("A", actual);*/
		
	/*	credentialsBean.setUserID("ABC12");
		credentialsBean.setPassword("321");
		actual=userImpl.login(credentialsBean);
		assertEquals("INVALID", actual);
*/
	}
	
	

	@Test
	public void testLogout()
	{
		
		/*UserImpl userImpl = new UserImpl();
		boolean status=false;*/
		
		/*status=userImpl.logout("Ab1000");
		assertEquals(true, status);*/
		
		/*status=userImpl.logout("Ab1800");
		assertEquals(false, status);*/
		
		/*status=userImpl.logout(null);
		assertEquals(false, status);*/
		
	}
	
	
	@Test
	public void testChangePassword()
	{
		
	/*	UserImpl userImpl = new UserImpl();
		String actual=null;
		CredentialsBean credentialsBean= new CredentialsBean();
	*/
		
		/*credentialsBean.setUserID("Ja1002");
		actual=userImpl.changePassword(credentialsBean, "12345");
		assertEquals("SUCCESS", actual);*/
		
		
	/*	credentialsBean.setUserID(null);
		actual=userImpl.changePassword(credentialsBean, "12345");
		assertEquals("FAIL", actual);*/
		
		/*credentialsBean=null;
		actual=userImpl.changePassword(credentialsBean, "12345");
		assertEquals("FAIL", actual);*/

	}
	
	
	
	@Test
	public void testRegister()
	{
/*		UserImpl userImpl = new UserImpl();
		String actual=null;
		ProfileBean profileBean= new ProfileBean();
		*/
		/*profileBean=null;
		actual=userImpl.register(profileBean);
		assertEquals("FAIL", actual);*/
		
		
		
		/*userImpl.registerCredentials("AB9999");	
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dd=null;
		try 
		{
			dd = sdf.parse("2014-11-12");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}

		profileBean.setDateOfBirth(dd);
		profileBean.setCity("Zila Ghaziabad");
		profileBean.setUserID("AB9999");
		profileBean.setEmailID("abhilash@wipro.com");
		profileBean.setFirstName("Abhi");
		profileBean.setGender("Male");
		profileBean.setLastName("Baniya");
		profileBean.setLocation("Malhar");
		profileBean.setMobileNo("9211420786");
		profileBean.setPincode("696969");
		profileBean.setState("Degraded");
		profileBean.setStreet("Wipro");
		actual=userImpl.register(profileBean);
		assertEquals("SUCCESS", actual);*/
		
	/*
		
		
		
		userImpl.registerCredentials("AB9999");	
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dd=null;
		try 
		{
			dd = sdf.parse("2014-11-12");
		} 
		catch (ParseException e) 
		{
			e.getMessage();
		}

		profileBean.setDateOfBirth(dd);
		profileBean.setCity("Zila Ghaziabad");
		profileBean.setUserID("AB9999");
		profileBean.setEmailID("abhilash@wipro.com");
		profileBean.setFirstName(null);
		profileBean.setGender("Male");
		profileBean.setLastName("Baniya");
		profileBean.setLocation("Malhar");
		profileBean.setMobileNo("9211420786");
		profileBean.setPincode("696969");
		profileBean.setState("Degraded");
		profileBean.setStreet("Wipro");
		actual=userImpl.register(profileBean);
		assertEquals("ERROR", actual);
					*/
	}
	
}
