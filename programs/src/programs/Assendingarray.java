package programs;
public class Assendingarray {
    public static void main(String[] args) {
	int[] MarksArray = new int[]{44,88,22,77,99};
	int temp;
	for(int i=0;i<MarksArray.lenth;i++)
	{
    for(int j=i;j<marksArray.lenth;j++)
    	if(MarksArray[i]>MarksArray[j])
    	{
    		temp=MarksArray[i];
    		MarksArray[i]=MarksArray[j];
    		MarksArray[j]=temp;
    	}
	}
	}
	for(int a:MarksArray)
	{
		System.out.println()
	}
}