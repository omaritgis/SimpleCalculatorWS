package dummy.WS.project;

import javax.servlet.http.HttpServletRequest;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;

public class DemoTest {
	public int statusCode;

//	@Before
	public void setUp() throws Exception {
	}

//	@After
	public void tearDown() throws Exception {
	}
	/*
	 * StatusCodes = 
	 * 0 - Working good
	 * 1 - Input error
	 * 2 - Logical error
	 */

//	@Test
	public int testNumber(HttpServletRequest num) {
		statusCode = 0; 
		try {
			 Double.parseDouble(num.getParameter("num1"));
			 Double.parseDouble(num.getParameter("num2"));
		 }catch(Exception e) {
//			 Assert.fail();
			 statusCode++;
		 }
		return statusCode;
	}
	
//	@Test
	public int testOperation(HttpServletRequest request) {
		statusCode = 0;
		try {
			String operation = request.getParameter("operation");
			statusCode = operation.contentEquals("addition") || operation.contentEquals("subtraction") || 
					operation.contentEquals("multiplication") || operation.contentEquals("division") ? 0 : 1;
		}catch(Exception e) {
			statusCode++;
		}
		return statusCode;
	}
	
//	@Test
	public int testAddition(double num1, double num2) {
		statusCode = 0; 
		try {
			Object d = num1+num2;
//			Assert.assertTrue(d instanceof Number);
			statusCode = d instanceof Number ? 0 : 1;
		}catch(Exception e) {
			statusCode = 2; //Logical error
//			Assert.fail();
		}
		return statusCode;
	}
	
//	@Test
	public int testSubtraction(double num1, double num2) {
		statusCode = 0;
		try {
			Object d = num1-num2;
//			Assert.assertTrue(d instanceof Number);
			statusCode = d instanceof Number ? 0 : 1;
		}catch(Exception e) {
			statusCode = 2; //Logical error
//			Assert.fail();
		}
		return statusCode;
	}
	
//	@Test
	public int testMultiplication(double num1, double num2) {
		statusCode = 0;
		try {
			Object d = num1*num2;
//			Assert.assertTrue(d instanceof Number);
			statusCode = d instanceof Number ? 0 : 1;
		}catch(Exception e) {
			statusCode = 2; //Logical error
//			Assert.fail();
		}
		return statusCode;
	}
	
//	@Test
	public int testDivision(double num1, double num2) {
		statusCode = 0;
		try {
			Object d = num1/num2;
//			Assert.assertTrue(d instanceof Number);
			statusCode = d instanceof Number ? 0 : 1;
		}catch(Exception e) {
			statusCode = 2; //Logical error, should catch division by 0
//			Assert.fail();
		}
		return statusCode;
	}

}
