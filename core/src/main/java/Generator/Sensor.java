package Generator;

import Main.SettingStore;

import java.util.Random;

/**
 * Implementations of this interface are used to generate SensorData of their respective types.
 */
public interface Sensor {

	/**
	 * Sets up the whole object. Required before any data can be generated.
	 * @param rng The Random object to use for retrieval of base numbers.
	 * @param noiseAlgorithm The NoiseAlgorithm that should transform numbers.
	 * @param settings SettingStore object used for additional setup of settings.
	 */
	void setup(Random rng, NoiseAlgorithm noiseAlgorithm, SettingStore settings);

	/**
	 * This method returns a complete SensorData object.
	 * @return SimpleSensorData
	 */
	SensorData getData();
}
