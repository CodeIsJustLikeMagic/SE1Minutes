package task7_2;

import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.function.BiFunction;

public class ExtensibleCalculator implements ExtensibleCalculatorIF{
	
	private Dictionary<String, BiFunction<Integer, Integer, Integer>> dictionary;
	
	public ExtensibleCalculator() {
		dictionary = new Hashtable<String, BiFunction<Integer, Integer, Integer>>();
	}

	@Override
	public String[] operations() {
		String[] ops = new String[dictionary.size()];
		List<String> l = Collections.list(dictionary.keys());
		ops = l.toArray(ops);	
		return ops;
	}

	@Override
	public void addOperation(String name, BiFunction<Integer, Integer, Integer> operation) {
		dictionary.put(name, operation);
		
	}

	@SuppressWarnings("null")
	@Override
	public int calc(String op, int x, int y) {
		BiFunction<Integer, Integer, Integer> operation = dictionary.get(op);
		if(operation != null) {
			return operation.apply(x, y);
		}
		return (Integer) null;
	}

}
