package task10_3;

import java.util.Date;

public abstract class Einnahmen{
	
	protected Statistics stats;

	final public double getRevenue(Date start, Date end) {
		return calculateRevenue(getStats(start, end));
	}

	abstract protected double calculateRevenue(ParkedCar[] stats);

	private ParkedCar[] getStats(Date start, Date end) {
		return stats.getCars(start, end);
	}

}
