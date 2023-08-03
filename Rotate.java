import java.util.Scanner;
class Rotate
{
public static void main(String[] args)
{
int a[]={10,29,45,67,12};
int k=3;
int j;
int n=a.length -1;
while(k>0)
{
	
	for(j=n; j>0; j--)
	{
	int temp;
	temp=a[j];
	a[j]=a[j-1];
	a[j-1]=temp;
	}
	k--;
	}
	for(int i=0;i<=n;i++)
	{
	
	System.out.println("array" + a[i]);
	}
	}
	}
	