package dp.creational.factory;

public class FactoryPattern {

	public static void main(String[] args) {
		VehicleFactory.getVehicle(3).printVehicle();
		VehicleFactory.getVehicle(4).printVehicle();
		VehicleFactory.getVehicle(13).printVehicle();

	}

}
