package dp.creational.factory;

public class VehicleFactory {
	public static Vehicle getVehicle(int type) {
		if (type == 2) {
			return new TwoWheeler();
		} else if (type == 3) {
			return new ThreeWheeler();
		} else if (type == 4) {
			return new FourWheeler();
		}
		return new Vehicle();
	}

}
