package programs;
import java.util.*;
public class Interface{
	void print()
}
class example implements Interface{
	public void print(){
		System.out.println("Hello ,good morning");
	}
}
public static void main(String[] args){
		{
			example e = new example();
			e.print();
		}

	}


