package task10_3;

import java.util.ArrayList;
import java.util.Date;

public class Statistics {

	public ParkedCar[] parkedCars;

	public ParkedCar[] getCars(Date start, Date end) {
		ArrayList<ParkedCar> list = new ArrayList<ParkedCar>();
		for(ParkedCar c : parkedCars) {
			if(c.in.compareTo(start) >= 0 && c.out.compareTo(end) <= 0) {
				list.add(c);
			}
		}
		return (ParkedCar[]) list.toArray();
	}
	
	public Statistics(ParkedCar[] cars) {
		parkedCars = cars;
	}
}
