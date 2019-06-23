package task9_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import Task1.SequenceCheck;

public class TopSortIterator implements Iterator<String> {
	
	private SequenceCheck checker;
	private String[][] topOrder;
	private ArrayList<String> order;

	public TopSortIterator(String[][] order) {
		topOrder = order;
		checker = new SequenceCheck();
		checker.setDependencies(topOrder);
		this.order = new ArrayList<String>();
	}

	@Override
	public boolean hasNext() {
		for(String[] part : topOrder) {
			for(String s : part) {
				if(order.contains(s)) {
					
				}
				else {
					order.add(s);
					String[] sequence = order.toArray(new String[order.size()]);
					if(checker.isWellSorted(sequence)) {
						order.remove(order.size() - 1);
						return true;
					}
					else {
						order.remove(order.size() - 1);
					}
				}
				
			}
		}
		return false;
	}

	@Override
	public String next() {
		for(String[] part : topOrder) {
			for(String s : part) {
				if(order.contains(s)) {
					
				}
				else {
					order.add(s);
					String[] sequence = order.toArray(new String[order.size()]);
					if(checker.isWellSorted(sequence)) {
						return s;
					}
					order.remove(order.size() - 1);
				}
				
			}
		}
		throw new NoSuchElementException();
	}
	
		

}
