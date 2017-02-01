package Generator;

import Main.SettingProvider;

import java.util.Random;

/**
 * This class is used for objects that create the SensorData. Can have different types, which are implemented inside this class.
 */
public class Sensor {

	/**
	 * The types of sensors implemented. Each type corresponds to a private function used to create SensorData objects.
	 */
	enum TYPE {
		TEMPERATURE,
	}

	/**
	 * Holds the generator function that creates the actual SensorData object.
	 */
	private SensorDataSupplier supplierObject;

	/**
	 * On creation, stores a reference to the RNG in the object.
	 * @param rng Random
	 * @param sensorType The type this sensor should represent.
	 */
	Sensor(Random rng, NoiseAlgorithm noiseAlgorithm, TYPE sensorType) {
		switch (sensorType) {
			case TEMPERATURE:
				this.supplierObject = new TemperatureDataSupplier(rng, noiseAlgorithm, SettingProvider.getSettingStore());
				break;
			default:
				break;
		}
	}

	/**
	 * This method returns a complete SensorData object.
	 * @return SensorData
	 */
	public SensorData getData() {
		return this.supplierObject.get();
	}
}
