//Design a Java program that defines a list of strings. The program should prompt the user for
//an index and display the element at that index. Handle the scenario where the user enters
//an invalid index (out of bounds) or tries to access an element from a null list. Throw
//appropriate exceptions (IndexOutOfBoundsException and NullPointerException) with
//informative messages.

import java.util.ArrayList;
import java.util.Scanner;

public class Q6 {
public static void main(String[] arg)
{
	ArrayList<String> sl=new ArrayList<>();
	sl.add("twinkle");
	sl.add("bulbul");
	sl.add("tinku"); 
	try (Scanner sc = new Scanner(System.in)) {
		System.out.print("Enter a index");
		try
		{
			int index=sc.nextInt();
			String element=getElementAtIndex(sl,index);
			System.out.println("Element at index"+index+":"+element);
}
		catch(IndexOutOfBoundsException e)
		{
			System.out.print("Invalid index");
		}
		catch(NullPointerException e)
		{
			System.out.print("list is null");
		}
		catch(Exception e)
		{
			System.out.print("error");
		}
	}
}

private static String getElementAtIndex(ArrayList<String> list, int index) throws IndexOutOfBoundsException, NullPointerException{
	// TODO Auto-generated method stub
	if(list==null)
	{
		throw new NullPointerException();
	}
	if(index<0||index>=list.size())
	{
		throw new IndexOutOfBoundsException();
	}
	return list.get(index);
}
}
