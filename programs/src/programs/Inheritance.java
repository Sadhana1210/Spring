package programs;
import java.util.Scannar;
 class Inheritance {
	int s=10;
	int l=20;
	int b=30;
	int s1=25,s2=35,s3=45;
	}
class square extends Inheritance{
	int area;
	void calarea()
	{
		a=s*s;
		System.out.println(area);
	}
	
}
class reactangular extends Inheitance{
	int p,area;
	void calculate()
	{
		p=2*(l+b);
		System.out.println("perimeter="+p);
		System.out.println("area="+area);
	}
} 
public class Mianc{
	public static void main(String args[]){
		sqaure s=new sqaure();
		reactagular r=new reactangular();
		s.calarea();
		r.calculate();
		}
}
