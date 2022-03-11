package calculator;

import java.util.ArrayList;

public interface Operation {
	public Float doOperation(ArrayList<Float> numbers) throws OperationException;
}
