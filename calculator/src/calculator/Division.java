package calculator;

import java.util.ArrayList;

public class Division implements Operation {

	@Override
	public Float doOperation(ArrayList<Float> numbers) throws OperationException {
		if(numbers.size() <= 0) {throw new OperationException("There must be at least 1 number in the operation.");}
		
		Float total = numbers.get(0);
		numbers.remove(0);
		for(Float number : numbers) {
			total /= number;
		}
		
		return total;
	}

}
