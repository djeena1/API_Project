package view;
import core.*;
import java.util.Scanner;
public class Features {
	public static void menu()
	{
		Scanner read = new Scanner(System.in);
		System.out.println("Please make a choice");
		System.out.println("\n1- Calculation on the Mathematical Expression\n2- Calculation on the Square\n3- "
				+ "Calculation on the Rectangle\n4- Calculation on the Triangle");
		int choix = read.nextInt();
		
		while (choix < 1 || choix > 4) {
			System.out.println("Please choose the correct number");
			choix = read.nextInt();
		}
		
		switch (choix)
		{
			case 1:
				mathExpression();
				break;
			case 2:
				squareComputation();
				break;
			case 3:
				rectangleComputation();
				break;
			case 4:
				triangleComputation();
				break;
		}
	}
	
	public static void mathExpression()
	{
		Scanner read = new Scanner(System.in);
		Scanner read_int = new Scanner(System.in);
		System.out.println(" Please enter the number of mathematical expression you want to calculate.");
		int number = read_int.nextInt();
		
		while(number <= 0)
		{
			System.out.println("Please enter a positive number");
			number = read_int.nextInt();
		}
		
		for (int j = 0; j < number; j++) {
			System.out.println("Please enter the expression position " + (j + 1));
			String expression = read.nextLine();
			Expression exp = new Expression(expression);
			DAO.getInstance().getExpressions().add(exp);
		}
		
		System.out.println("\n\nTHE RESULTS ARE\n\n");
		
		for (Expression expr : DAO.getInstance().getExpressions())
		{
			System.out.println(expr.getExpression() + " = " + expr.executeExpression());
		}
	}
	
	public static void squareComputation()
	{
		Scanner read = new Scanner(System.in);
		System.out.println("Please enter the width of the square");
		
		int width = read.nextInt();
		
		while(width <= 0)
		{
			System.out.println("Please enter a positive number");
			width = read.nextInt();
		}
		Square sqr = new Square(width);
		System.out.println("1- Compute area of this square\n2- Compute perimeter");
		int choix = read.nextInt();
		
		while (choix < 1 || choix > 2) {
			System.out.println("Please choose a correct number");
			choix = read.nextInt();
		}
		
		switch (choix)
		{
			case 1:
				System.out.println("The area of this square is : " + sqr.area());
				break;
			case 2:
				System.out.println("The perimeter of this square is : " + sqr.perimeter());
				break;
		}
	}
	
	public static void rectangleComputation()
	{
		Scanner read = new Scanner(System.in);
		System.out.println("Please enter the width of the rectangle");
		
		int width = read.nextInt();
		
		while(width <= 0)
		{
			System.out.println("Please enter a positive number");
			width = read.nextInt();
		}
		
		System.out.println("Please enter the height of the rectangle");
		
		int height = read.nextInt();
		while(height <= 0)
		{
			System.out.println("Please enter a positive number");
			width = read.nextInt();
		}
		
		
		Rectangle rect = new Rectangle(height, width);
		System.out.println("1- Compute area of this rectangle\n2- Compute perimeter of the rectangle");
		int choix = read.nextInt();
		
		while (choix < 1 || choix > 2) {
			System.out.println("Please choose a correct number");
			choix = read.nextInt();
		}
		
		switch (choix)
		{
			case 1:
				System.out.println("The area of this square is : " + rect.area());
				break;
			case 2:
				System.out.println("The perimeter of this square is : " + rect.perimeter());
				break;
		}
	}
	
	public static void triangleComputation()
	{
		Scanner read = new Scanner(System.in);
		System.out.println("Please enter the first axis");
		int ax1 =  read.nextInt();
		int base = ax1;
		System.out.println("Please enter the second axis");
		int ax2 = read.nextInt();
		System.out.println("Please enter the third axis");
		int ax3 = read.nextInt();
		System.out.println("Please enter the height");
		int height = read.nextInt();
		
		Triangle tri = new Triangle(height, base, ax1, ax2, ax3);
		
		System.out.println("1- Compute area of the triangle\n2- Compute perimeter of the triangle");
		int choix = read.nextInt();
		
		while (choix < 1 || choix > 2) {
			System.out.println("Please choose a correct number");
			choix = read.nextInt();
		}
		
		switch (choix)
		{
			case 1:
				System.out.println("The area of this triangle is : " + tri.area());
				break;
			case 2:
				System.out.println("The perimeter of this triangle is : " + tri.perimeter());
				break;
		}
	}
}