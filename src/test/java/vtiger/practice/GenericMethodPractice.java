package vtiger.practice;

public class GenericMethodPractice {

	public static void main(String[] args) {//caller
		
		int result=add(75,63);
		System.out.println(result);
		
	}
	
	public static int add(int a ,int b) //called
	{
		int c=a+b;
		return c;
	}
	
}
