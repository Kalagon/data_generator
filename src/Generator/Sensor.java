package Generator;

import java.util.Random;

/**
 * Template class for Sensors. The specific Sensors have to implement abstract methods to be usable in the Generator.
 */
public abstract class Sensor {
	/**
	 * Used to store a reference to the RNG used for raw number generation.
	 */
	Random rng;

	/**
	 * This method returns a complete SensorData object filled with processed random data.
	 * @return SensorData
	 */
	public abstract SensorData getData();
}
