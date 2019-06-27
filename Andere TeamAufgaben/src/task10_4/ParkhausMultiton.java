package task10_4;

import java.util.ArrayList;

public class ParkhausMultiton {
	
	private ArrayList<VehicleIF> vehicles;
	
	private static final ParkhausMultiton instance = new ParkhausMultiton();
	
	public static ParkhausMultiton getInstance() {
		return instance;
	}
	
	private ParkhausMultiton() {
		vehicles = new ArrayList<VehicleIF>();
		vehicles.add(Zweirad.getInstance());
		vehicles.add(Trike.getInstance());
		vehicles.add(Quad.getInstance());
		vehicles.add(SUV.getInstance());
		vehicles.add(PKW.getInstance());
		vehicles.add(Pickup.getInstance());
		
	}
	
	public void addVehicle(VehicleIF vehicle) {
		vehicles.add(vehicle);
	}
	
	public <T extends VehicleIF> VehicleIF getVehicle(Class<T> vehicle){
		for(VehicleIF v : vehicles) {
			System.out.println(v.getClass().toString());
			if(v.getClass().equals(vehicle)) {
				return v;
			}
		}
		//should be reached if vehicle not part of multiton be reached
		return null;
	}
}
