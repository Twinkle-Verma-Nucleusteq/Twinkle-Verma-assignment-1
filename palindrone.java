import java.util.Scanner;
public class palindrone
{
	public static void main(String[] args)
{
	
	Scanner sc=new Scanner(System.in);
	int num=sc.nextInt();
	int sum=0;
	int r;
	int n=121;
	int temp=n;
	while(num>0)
	{
	r=num%10;
	sum=(sum*10)+r;
	num=num/10;
	}
	if(temp==num)
		System.out.print("No. is palindrone");
	else
		System.out.print("No. is not palindrone");
}
}
