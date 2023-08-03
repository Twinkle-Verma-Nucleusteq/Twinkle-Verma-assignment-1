import java.util.Scanner;
public class quadratic
{
	public static void main(String[] args)
	{
	double root1=0,root2=0;
	Scanner sc = new Scanner(System.in);
 System.out.print("Enter a: ");
	double a =sc.nextDouble();
System.out.print("Enter b: ");
	double b =sc.nextDouble();
	System.out.print("Enter c: ");
	double c =sc.nextDouble();
	double d=(b*b)-(4*a*c);
	double sqrt=Math.sqrt(d);
	if(d>0)
	{
	root1=(-b+sqrt)/(2*a);
	root2=(-b+sqrt)/(2*a);
	System.out.println("Root::"+root1+"&"+root2);
	}
	else if(d==0)
	{
	System.out.println("Root is::" +(-b+sqrt)/(2*a));
	}
	}
	}