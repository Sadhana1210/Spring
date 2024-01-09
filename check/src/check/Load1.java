package check;
//public class Load1 {  
//	// Create a Main class
//	
//	  int x;  // Create a class attribute
//
//	  // Create a class constructor for the Main class
//	  public Load1() {
//	    x = 5;
//	    // Set the initial value for the class attribute x
//	  }
//	   class Load2 extends Load1{
//		  public Load2() {
//			    x = 6;
//	  }
//	  
//
//	  public static void main(String[] args) {
//	    Load1 myObj = new Load2(); // Create an object of class Main (This will call the constructor)
//	    System.out.println(myObj.x); // Print the value of x
//	  }
//	} 
//}
public class Load1{
	public void Hi() {
		System.out.println("Hii");
	}
	}
	 class Load2 extends Load1{
		public void Hi() {
			System.out.println("Hloo");
		}
	
		 public static void main(String[] args) {
			    Load2 myObj = (Load2) new Load1(); // Create an object of class Main (This will call the constructor)
			    myObj.Hi();
		}
}