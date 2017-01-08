package Generator;

import java.util.Random;

/**
 * Factory class for TemperatureSensor creation.
 */
public class TemperatureSensorFactory implements SensorFactory {

	/**
	 * This creates a new TemperatureSensor.
	 *
	 * @param rng Reference to the RNG
	 * @return Sensor
	 */
	@Override
	public TemperatureSensor create(Random rng) {
		return new TemperatureSensor(rng);
	}
}
