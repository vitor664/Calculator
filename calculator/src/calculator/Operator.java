package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Operator {
	private String operatorType;
	private Operation operation;
	private ArrayList<String> availableOperator = new ArrayList<String>(Arrays.asList("+","-","/","*"));
	
	public Operator(String operatorType) throws OperationException {
		this.setOperatorType(operatorType);
	}
	
	public Operation getOperation() {
		switch (this.getOperatorType()) {
		case "+":
			setOperation(new Addition());
			break;
		case "-":
			setOperation(new Subtraction());
			break;
		case "/":
			setOperation(new Division());
			break;
		case "*":
			setOperation(new Multiplication());
			break;
		default:
			setOperation(null);
			break;
		}
		
		return this.operation;
	}
	
	private void setOperation(Operation operation) {
		this.operation = operation;
	}

	public String getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(String operatorType) throws OperationException {
		if(!this.availableOperator.contains(operatorType)) {throw new OperationException("Invalid operator.");}
		this.operatorType = operatorType;
	}
}
