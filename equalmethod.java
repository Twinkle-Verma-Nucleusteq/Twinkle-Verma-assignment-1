import java.lang.String;
public class equalmethod
{
	public static void main(String[] args)
	{
	String t1="Hello";
	String t2="Hello";
	String t3= new String("Hello");
	System.out.println(t1==t2);true
	System.out.println(t1==t3);false
	System.out.println(t2==t3);false
	System.out.println(t2.equals(t3));true
	}
	}
	