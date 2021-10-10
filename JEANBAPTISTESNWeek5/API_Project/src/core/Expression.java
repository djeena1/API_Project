package core;
import model.MathOperations;
import java.util.ArrayList;
import model.MathOperations;

public class Expression {
	//public Expression() {System.out.println();} 
	
	private String expression;
	
	public Expression(String exp)
	{
		this.expression = exp;
	}
	
	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	
	public double executeExpression()
	{
		String exp = this.getExpression();
		int indexOperator = -1;
		
		ArrayList<String> array = new ArrayList<String>();
		
		array.add("*");
		array.add("/");
		array.add("+");
		array.add("-");
		
		ArrayList<String> operations = new ArrayList<String>();
		
		double result = -1;
		double op1  = -1;
		double op2 = -1; 
		
		if (this.expression.indexOf("*") == -1 && this.expression.indexOf("/") == -1 && 
				this.expression.indexOf("+") == -1 && 
				(this.expression.indexOf("-") == -1 || (this.expression.indexOf("-") == 0 && 
				exp.length() - exp.replace("-", "").length() == 1))) {
			return Double.valueOf(this.expression);
		}
		
		int i = 0;
		while(i < this.getExpression().length())
		{
			String temp = "";
			while (i < this.getExpression().length() && !array.contains(String.valueOf(this.getExpression().charAt(i)))) {
				temp += this.getExpression().charAt(i);
				i++;
			}
			if (!temp.equals(""))
				operations.add(temp);
			if(i < this.getExpression().length())
			{
				operations.add(String.valueOf(this.getExpression().charAt(i)));
			}
			
			i++;
		}
		
		
		//If any product is necessary, we try to know if a division is necessary
		indexOperator = operations.indexOf("*");
		if (indexOperator == -1)
			indexOperator = operations.indexOf("/");
		
		//Else, we check for addition
		if (indexOperator == -1)
			indexOperator = operations.indexOf("+");
		
		//Else, we check for subtraction
		if (indexOperator == -1)
			indexOperator = operations.indexOf("-");
		
		if(indexOperator == 0)
		{
			op1 = Double.valueOf(operations.get(1)) * (-1);
			op2 = Double.valueOf(operations.get(3));
		}
		else
		{
			op1 = Double.valueOf(operations.get(indexOperator - 1));
			op2 = Double.valueOf(operations.get(indexOperator + 1));
		}
		
		switch (operations.get(indexOperator)) {
		case "*":
			result = MathOperations.mult(op1, op2);
			break;
		case "/":
			result = MathOperations.div(op1, op2);
			break;
		case "+":
			result = MathOperations.add(op1, op2);
			break;
		case "-":
			result = MathOperations.subs(op1, op2);
			break;
		}

		String newExpression = "";
		
		if (indexOperator == 0)
		{
			newExpression += String.valueOf(result);
			for(int k = 4; k < operations.size(); k++)
				newExpression += operations.get(k);
		}
		else
		{
			for (int j = 0; j < operations.size(); j++) {
				if (j < indexOperator - 1 || j > indexOperator + 1)
					newExpression += operations.get(j);
				if (j == indexOperator)
					newExpression += String.valueOf(result);
			}
		}
		
		this.setExpression(newExpression);
		return this.executeExpression();
	}

	@Override
	public String toString() {
		return expression;
	}
	
	
}