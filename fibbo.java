//
package allquestionMultithreading;
import java.util.Scanner;

public class fibbo {
	public static int[] reverseArr(int[] arr)
	{
		int[] reverseArr=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			reverseArr[i]=arr[arr.length-1-i];
		}
		return reverseArr;
		}
	
	public static int[] fibboSeries(int n)
	{
		if(n<=0)return new int[0];
	int[] fibboArr=new int[n];
	fibboArr[0]=0;
	if(n>1)
	{
		fibboArr[1]=1;
		for(int i=2;i<n;i++)
		{
			fibboArr[i]=fibboArr[i-1]+fibboArr[i-2];
		}
	}
	return fibboArr;
	}
	public static int sumNum(int[]arr)
	{
		int sum=0;
		for(int num:arr)
		{
			sum+=num;
		}
		return sum;
	}
	public static void main(String[] args )
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter  integer");
				int no =sc.nextInt();
				sc.close();
				int [] numberA=new int[no-1];
				for(int i=0;i<numberA.length;i++) {
					numberA[i]=i+1;}
				Thread revThread=new Thread(()->{
					int[] reverseArr= reverseArr(numberA);
					System.out.println("Reversed list:");
					for(int num:reverseArr) {
						System.out.print(num+"");
					}
					System.out.println();
	});
				Thread fibboThread=new Thread(()->{
					int[] fibboArr= fibboSeries(no);
					System.out.println("fibbo list:");
					for(int num:fibboArr) {
						System.out.print(num+"");
					}
					System.out.println();
				});
				Thread sumThread=new Thread(()->{
					int[] sumNum= (numberA);
					System.out.println("sum of num:"+sumNum);
				});
			try {
				
			
				revThread.join();
				fibboThread.join();
				sumThread.join();
			}
			catch(InterruptedException e)
			{
				e.getStackTrace();			}
				
				
	}
	}
				
				
				
				