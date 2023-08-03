//custom exception
class InvalidDimensionException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidDimensionException(String message)
	{
		super(message);
	}
}
class areaRec {
public static int area(int l,int w) throws InvalidDimensionException
{
	if(l<=0||w<=0)
	{
		throw new InvalidDimensionException("length and width must be positive:");
	}
	return l*w;
}
}
public class Q3
{
	public static void main(String[] args)
	{
		try
		{
			int A= areaRec.area(47, 80);
					System.out.println("Area of rectangle valid:"+A);
			int A1= areaRec.area(-2, 7);
					System.out.println("Area of rectangle invalid:"+A1);
			
		}
		catch(InvalidDimensionException e)
		{
			System.out.print("Error:"+e.getLocalizedMessage());	
		}
	}
}