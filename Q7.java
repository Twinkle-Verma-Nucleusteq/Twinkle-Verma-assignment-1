import java.util.ArrayList;
import java.util.Scanner;

public class Q7 {
		public static void main(String[] arg)
		{
			int[] arr= {1,2,3,4,5,6};
			Scanner sc = new Scanner(System.in); 
				System.out.print("Enter a index");
				int index=sc.nextInt();
				try
				{
					if(arr==null)
					{
						throw new NullPointerException("array is null:");
					}
					if(index<0||index>=arr.length)
					{
						throw new IndexOutOfBoundsException("invalid index:");
					}
					
					int element=arr[index];
					System.out.println("Element at index"+index+":"+element);
				}
				catch(IndexOutOfBoundsException e)
				{
					System.out.print(e.getMessage());
				}
				catch(NullPointerException e)
				{
					System.out.print(e.getMessage());
				}
				
				sc.close();
				
		}


}