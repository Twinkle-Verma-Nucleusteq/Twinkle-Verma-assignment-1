/*write a program to calculate Area of -
 Rectangle
 Circle
 Triangle
Make use of Appropriate annotations and javadoc .*/
import java.util.Scanner;
/** area of rectangle,circle and triangle.
 * 
 */
	public class Q1 {
		/**
		 * area of rectangle,circle and triangle
		 * @param l-length
		 * @param w-width
		 * @return area of rectangle
 * 
		 */
		public static double rectangle(double l,double w)
		{
			return l*w;
		}
	
			/**
			 * area of rectangle,circle and triangle
			 * @param r-radius
			 * @return area of circle
	 * 
			 */
			public static double circle(double r)
			{
				return Math.PI*r*r;
			}
			/**
			 * area of rectangle,circle and triangle
			 * @param b-base
			 * @param h-height
			 * @return area of triangle
	 * 
			 */
			public static double traingle(double b,double h)
			{
				return 0.5*b*h;
			}
			public static void main(String[] args) {
				Scanner sc=new Scanner(System.in);
				//rectangle
				System.out.print("Enter length:");
				double rl=sc.nextDouble();
				System.out.print("Enter width:");
				double rw=sc.nextDouble();
				double ra=rectangle(rl,rw);
				System.out.println("Area of rectangle"+ra);
				
				//circle
				System.out.print("Enter radius:");
				double rad=sc.nextDouble();
				
				double ac=circle(rad);
				System.out.println("Area of circle"+ac);
				
				//triangle
				System.out.print("Enter base:");
				double b1=sc.nextDouble();
				System.out.print("Enter height:");
				double h1=sc.nextDouble();
				double ta=rectangle(b1,h1);
				System.out.println("Area of traingle"+ta);
				sc.close();
			}
}