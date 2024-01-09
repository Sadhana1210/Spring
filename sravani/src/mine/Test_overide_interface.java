package mine;
interface shape{
	public double Area();
}
	class Circle1 implements shape{
		 private double radius;
		public Circle1(double radius) {
		this.radius=radius;
		}
		public double Area() {
			return Math.PI*radius*radius;
		}
	}
class Rectangle1 implements shape{
	private double length;
	private double breadth;
	public Rectangle1 (double length,double breadth) {
		this.breadth=breadth;
		this.length=length;
	}
	public double Area() {
		return breadth*length;
	}
}
public class Test_overide_interface {
public static void main(String[] args) {
	Circle1 t=new Circle1(1.2);
	System.out.println(t.Area());
	Rectangle1  r=new Rectangle1(1.2,1.3);
	System.out.println(r.Area());
	
}
}
