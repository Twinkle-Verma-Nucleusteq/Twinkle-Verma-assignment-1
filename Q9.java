

import java.util.*;
@SuppressWarnings("serial")
class NotEvenNumberException extends Exception
{
	public NotEvenNumberException(String msg)
	{
		super(msg);
	}
	
}
public class Q9 {

	    public static void main(String[] args)
	    {
	    	
	        Scanner sc = new Scanner(System.in);
try {
	

	        System.out.print("Enter a number: ");
	        int num = sc.nextInt();
	        checkEvenNumbers(num);

}
catch (NotEvenNumberException e)
{
	System.out.println("Error:"+e.getMessage());
}
catch (Exception e)
{
	System.out.println("Error:Invalid Input.");
}
finally
{
	sc.close();
}
	    }
	    
public static void checkEvenNumbers(int num)throws NotEvenNumberException
{
if(num % 2 == 0)
	
	        {
	        	throw new NotEvenNumberException("even number");
	        }
	            //System.out.println(num + " is even");
	        
	        else
	            System.out.println(num + " is odd");
	    }
	}
