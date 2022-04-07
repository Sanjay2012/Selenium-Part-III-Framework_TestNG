package testNG.DataProvider;

import org.testng.annotations.DataProvider;

public class LoginTestData {
	@DataProvider(name="LoginDataProvider")
	public Object[][] getData(){
		Object[][] data= {{"KW0610", "Shiv@123", "152022", "SB"}};
		return data;
	}

}
