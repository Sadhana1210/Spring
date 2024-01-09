package mine;

public class SeperateSpecialCharsInString {
public static void main(String[] args) {
	String s="miracle.soft@gmail.com";
	String s1="";
	String s2="";
	for(int i=0;i<s.length();i++) {
		char c=s.charAt(i);
//		System.out.println(c);
//		s2+=c;
		if(Character.isLetter(c)) {
			s1+=c;
		}
		else {
			s2+=c;
							}
	}
	System.out.println(s1);
	System.out.println(s2);
}
}
