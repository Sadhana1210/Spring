package mine;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

class Student implements Serializable{
	String name;
	int id;
	Student( int id, String name){
		this.id=id;
		this.name=name;
	}
}
public class Test_serializable {
public static void main(String[] args) throws IOException, ClassNotFoundException {
	FileOutputStream f=new FileOutputStream("file1.txt"); 
	ObjectOutputStream o=new ObjectOutputStream(f);
	LinkedList<Student>l=new LinkedList();
	Student s1=new Student(1,"sadana");
	Student s2=new Student(2,"sai");
l.add(s1);
l.add(s2);
for(Student s:l) {
o.writeObject(s);
}
FileInputStream f1=new FileInputStream("file1.txt");
ObjectInputStream o1=new ObjectInputStream(f1);
while(o1!=null) {
Student s=(Student)o1.readObject();
	System.out.println(s.id+" "+s.name);
}
}
}
