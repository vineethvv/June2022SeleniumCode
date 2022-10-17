package testNGsessions;

import org.testng.annotations.Test;

public class DependsOnMethodsConcept {
	
	// This concept is not recommended
	
	
	//AAA in unit test
		//Arrange, Act, and Assert 
		
		public void createAUser() {
			System.out.println("creating a user");
		}
		
		// IF the below method (a_createUser) is dependent on the other 2 methods ie updateUser & deleteUser , then if the 1st method fails then the other 2 methods will also fail
		
		@Test
		public void a_createUser() {
			System.out.println("create user");//100
			createAUser();//100
			//int i = 9/0;
		}
		
//		@Test(dependsOnMethods = "a_createUser")
//		public void updateUser() {
//			System.out.println("update user");
//
//		}
//	
//		@Test(dependsOnMethods = "a_createUser")
//		public void deleteUser() {
//			System.out.println("delete user");
//
//		}
		
		@Test()
		public void updateUser() {
			createAUser();//101
			System.out.println("update user");//101

		}
		
		@Test()
		public void deleteUser() {
			createAUser();//201
			System.out.println("delete user");//201

		}

}
