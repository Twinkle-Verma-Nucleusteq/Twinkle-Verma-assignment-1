import java.util.Scanner;
class ArithmeticOperations
{
public static void main(String[] args)
{
Scanner sc = new Scanner(System.in);
System.out.print("Enter first number: ");
double x1 =sc.nextDouble();
System.out.print("Enter second number: ");
double x2 =sc.nextDouble();
double sum=x1+x2;
double difference=x1-x2;
double product=x1*x2;
double quotient=x1/x2;
System.out.println("sum = "+ sum);
System.out.println("difference= " + difference);
System.out.println("product =" + product);
System.out.println("quotient =" + quotient);
}
}
