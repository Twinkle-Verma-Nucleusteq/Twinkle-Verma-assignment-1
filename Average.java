import java.util.Scanner;
class Average
{
public static void main(String[] args)
{
int a[]=new int[5];
Scanner sc=new Scanner(System.in);
System.out.print("Enter array Elements");
int n=sc.nextInt();
int sum=0;
	for(int i=00;i<5;i++)
	{
	a[i]=sc.nextInt();
	sum+=a[i];
	}
	System.out.println("Average is:"+sum/n);
	}
	}