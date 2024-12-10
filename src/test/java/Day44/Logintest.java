package Day44;

import org.testng.annotations.Test;

public class Logintest {

	
@Test(groups={"regression"})
 void loginupbyemail() {
		
		System.out.println("Login Run by email");
		
	}
	
@Test(groups={"regression"})
    void loginupbytwitter() {
		System.out.println("Login run by twitter");
	}
	
@Test(groups={"regression"})
     void loginupbyfacebook() {
		System.out.println("Login run by facebook");
	}
}

