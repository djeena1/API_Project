package core;
import model.MathOperations;


public class Triangle {
	private double height;
	private double base;
	private double axis1;
	private double axis2;
	private double axis3;
	
	
	
	
	public double getHeight() {
		return height;
	}


	public Triangle() {}

	public void setHeight(double height) {
		this.height = height;
	}


	

	public Triangle(double height, double base, double axis1, double axis2, double axis3) {
		this.height = height;
		this.base = base;
		this.axis1 = axis1;
		this.axis2 = axis2;
		this.axis3 = axis3;
	}


	public double getBase() {
		return base;
	}




	public void setBase(double base) {
		this.base = base;
	}




	public double getAxis1() {
		return axis1;
	}




	public void setAxis1(double axis1) {
		this.axis1 = axis1;
	}




	public double getAxis2() {
		return axis2;
	}




	public void setAxis2(double axis2) {
		this.axis2 = axis2;
	}


	public double getAxis3() {
		return axis3;
	}


	public void setAxis3(double axis3) {
		this.axis3 = axis3;
	}


	public double area()
	{
		return MathOperations.div(MathOperations.mult(this.getBase(), this.getHeight()), 2);
	}
	
	public double perimeter()
	{
		return MathOperations.add(axis1, MathOperations.add(axis2, axis3));
	}
}