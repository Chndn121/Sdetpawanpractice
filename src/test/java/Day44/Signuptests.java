package Day44;

import org.testng.annotations.Test;

public class Signuptests {

	
	
	@Test(priority=1,groups={"sanity"})
	 void signupbyemail() {
			
			System.out.println("Signup Run by email");
			
		}
		
	@Test(priority=3,groups={"sanity"})
	    void signupbytwitter() {
			System.out.println("signup run by twitter");
		}
		
	@Test(priority=-1,groups={"sanity"})
	     void signupbyfacebook() {
			System.out.println("Signup run by facebook");
		}
	}

