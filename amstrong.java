import java.util.Scanner;
public class amstrong
{
	public static void main(String[] args)
{
	
	Scanner sc=new Scanner(System.in);
	int num=sc.nextInt();
	int sum=0;
	while(num>0)
	{
	sum=sum +(num%10)*(num%10)*(num%10);
	num=num/10;
	}
	if(sum==num)
		System.out.print("No. is amstrong");
	else
		System.out.print("No. is not amstrong");
}
}
