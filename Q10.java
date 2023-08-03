import java.util.Scanner;

@SuppressWarnings("serial")
class InvalidpasswordException extends Exception
{

public  InvalidpasswordException(String message)	
{
	super(message);
}
}

public class Q10 {
	public static void main (String[] ar)
	{
		try (Scanner sc = new Scanner(System.in)) {
			try
			{
				System.out.println("Enter your password:");
				String pass=sc.nextLine();
				if(!isValidPassword(pass))
				{
					throw new InvalidpasswordException("invalid password");
				}
				System.out.println("Password is valid:");
			}
			catch(InvalidpasswordException e)
			{
				System.out.println("Error:"+e.getMessage());
			}
		}
	}
		public static boolean isValidPassword(String password)
		{
			if(password.length()<8)
			{
				return false;
			}
			boolean le=false;
			boolean no=false;
			for(char c:password.toCharArray()) {
				if(Character.isLetter(c))
			{
				le=true;
				
			}
			else if(Character.isDigit(c))
			{
				le=true;
				
			}
			if(le && no)
			{
				return true;
				
				
			}
			}
		return false;
		
		}
}
		
		
		