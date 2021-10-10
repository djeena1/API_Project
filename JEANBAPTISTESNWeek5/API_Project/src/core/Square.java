package core;

public class Square extends Quadrilateral{
	public Square() {
		
	}
	
	public Square(double weight) {
		super.setHeight(weight);
		super.setWeight(weight);
	}
}