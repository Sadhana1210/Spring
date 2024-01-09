package programs;

public class Overloads {
	public void sum (int a, int b)
	{
		System.out.println("a+b");
    }
	public void sum(int a, int b int c)
	{
		System.out.println(a+b+c);
	}

	public static void main(String[] args){
		Overloads oe = new Overloads();
		oe.sum(10,30);
		oe.sum(51,2,4);
		}
}
