package Day44;

import org.testng.annotations.Test;

public class Paymenttests {
	
	@Test(groups= {"sanity","regression"})
	void paymentbyemail() {
		System.out.println("payment by emial");
	}

	
	@Test(groups= {"sanity","regression"})
	void paymentbyphone() {
		System.out.println("payment by phone");
	}
	
	@Test(groups= {"sanity","regression"})
	void paymentbymobile() {
		System.out.println("payment by mobile");
	}


}
