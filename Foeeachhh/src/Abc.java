
public class Abc { 
	public float run(float a, long b) {
		System.out.println("doi");
		return a+b;
	}
		public long run(long a, long b) {
			System.out.println("hloo");
			return a+b;
		}
		
	
	    public static void main(String args[]){  
	    	Abc a= new Abc();	
	      System.out.println(a.run(2l,  5l));
	    
	      
	    }
}
