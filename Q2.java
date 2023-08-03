
//custom exception

import java.util.Scanner;

class InvalidinputException extends Exception

{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public InvalidinputException(String message)	
{
	super(message);
}
public class Q2 {
public static void main (String[] ar)
{
	try (Scanner sc = new Scanner(System.in)) {
		try
		{
			System.out.println("Enter your balance:");
			double bal=Double.parseDouble(sc.nextLine());
			if(bal<0)
			{
				throw new InvalidinputException("account balance cannot be negative");
			}
			System.out.println("Enter your withdraw:");
			double wda=Double.parseDouble(sc.nextLine());
			if(wda<=0)
			{
				throw new InvalidinputException(" withdraw account balance cannot be greater than zero");
			}
			if(wda>bal)
			{
				throw new InvalidinputException("insufficient balance");
			}
//		withdraw logic
		double remainingbal=bal-wda;
		System.out.println("withdraw successful:"+remainingbal);
		}
		catch (NumberFormatException e)
		{
			System.out.println("Enter only numeric value");
			
		}
		catch(InvalidinputException e)
		{
			System.out.println("Error:"+e.getMessage());
		}
	}
}
//sc.close();
	
}
}
