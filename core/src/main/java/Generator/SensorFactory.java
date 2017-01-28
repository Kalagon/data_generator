package Generator;

import java.util.Random;

/**
 * Factory class for Sensor creation. Subclasses must implement create to create specific Sensor types.
 */
public interface SensorFactory {
	/**
	 * This creates a new Sensor.
	 * @param rng Reference to the RNG
	 * @return Sensor
	 */
	Sensor create(Random rng);
}
