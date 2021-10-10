package core;

import model.MathOperations;

public abstract class Quadrilateral {
	private double weight;
	private double height;
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double area()
	{
		return MathOperations.mult(this.getHeight(), this.getWeight());
	}
	
	public double perimeter()
	{
		return MathOperations.mult(2,MathOperations.add(this.getHeight(), this.getWeight()));
	}
}