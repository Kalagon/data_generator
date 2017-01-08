package Generator;

import java.util.Random;

/**
 * Created by oskar on 29.12.16.
 */
public class TemperatureSensor extends Sensor {

	/**
	 * On creation, stores a reference to the RNG in the object.
	 * @param rng Random
	 */
	TemperatureSensor(Random rng) {
		this.rng = rng;
	}

	/**
	 * This method returns a complete SensorData object filled with processed random data.
	 * @return SensorData
	 */
	public SensorData getData() {
		return new SensorData(1, 1, "°C");
	}
}
