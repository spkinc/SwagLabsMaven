package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import pages.LoginPage;


public class LoginTest extends BaseClass {

	private LoginPage login;


	@Test
	public void positiveTest() throws FilloException, InterruptedException {
		login = new LoginPage(driver);
		Recordset recordset = connection.executeQuery("Select * From data Where TestName = 'PositiveTest'");
		recordset.next();
		String userName =recordset.getField("UserName");
		String password =recordset.getField("Password");
		login.LoginFunction(userName, password);
		Assert.assertEquals(login.getTitle(), "Products");
	}

	@Test
	public void negativeTest() throws FilloException, InterruptedException {
		login = new LoginPage(driver);
		Recordset recordset = connection.executeQuery("Select * From data Where TestName = 'NegativeTest'");
		recordset.next();
		String userName =recordset.getField("UserName");
		String password =recordset.getField("Password");
		String error =recordset.getField("Error");
		login.LoginFunction(userName, password);
		Assert.assertEquals(login.readErrorMsg(), error);
	}

}
