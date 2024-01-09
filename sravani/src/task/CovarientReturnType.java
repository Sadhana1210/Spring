
package task;
	class A {
	    A get(int a) {
	        return this;
	    }
//	    void message() {
//	    	System.out.println("hlo");
//	    }
	}

	class B1 extends A {
	    B1 get(int a) {
	        return this;
	    }

	    void message() {
	        System.out.println("welcome to covariant return type");
	    }
	}

	public class CovarientReturnType {
	    public static void main(String args[]) {
	        System.out.println(new B1().get(4));
	    }
	}

