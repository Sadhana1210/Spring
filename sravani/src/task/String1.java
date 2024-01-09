package task;

public class String1 {

	public static void main(String[] args) {
	String s="s@dhanavabili1 fgkaeiouhfgh piv ksg @314!";
	s.toLowerCase();
	int cv=0,cc=0,cd=0,sc=0,wc=1;
	for(int i=0;i<s.length();i++) {
		if(s.charAt(i)>='a'&&s.charAt(i)<='z') {
			if(s.charAt(i)=='a'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'||s.charAt(i)=='e') {
				cv++;
			}
			else {
				cc++;
			}
		}
		else if(s.charAt(i)>='0'&&s.charAt(i)<'9') {
			cd++;
		}
		else if(s.charAt(i)==' ') {
			wc++;
		}
		else {
			sc++;
		}
	}
System.out.println("vowels are"+cv);
System.out.println("consonents are"+cc);
System.out.println("digits are"+cd);
System.out.println("digits are"+cd);
System.out.println("words are"+wc);
System.out.println("special are"+sc);
	}

}
