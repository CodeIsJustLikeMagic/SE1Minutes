package task10_3;

public class Einnahmenberechner extends Einnahmen {

	@Override
	protected double calculateRevenue(ParkedCar[] stats) {
		double res = 0d;
		for(ParkedCar c : stats) {
			res += c.pricePayed;
		}
		return res;
	}
	
	public Einnahmenberechner(Statistics stats) {
		this.stats = stats;
	}

}
