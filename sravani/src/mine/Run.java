package mine;
class A
{
	static void run() {
		System.out.println("hlo");
	}
}
class B extends class A
{
static void run(int a, int b) {
	System.out.println(a+b);
}
}
	public class Run {
public static void main(String[] args) {
	A a= new A();
	a.run(1, 2);
}

}
