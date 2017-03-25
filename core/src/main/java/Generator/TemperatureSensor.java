package Generator;

import Main.SettingStore;

import java.util.Random;

/**
 * This class is used for objects that create the SimpleSensorData. Can have different types, which are implemented inside this class.
 */
public class TemperatureSensor implements Sensor {

	private float rangeMin;
	private int rangeDelta;
	private float precisionSetting;
	private Random rng;
	private NoiseAlgorithm noiseAlgorithm;

	/**
	 * Sets up the whole object. Required before any data can be generated.
	 * @param rng            The Random object to use for retrieval of base numbers.
	 * @param noiseAlgorithm The NoiseAlgorithm that should transform numbers.
	 * @param settings       SettingStore object used for additional setup of settings.
	 */
	public void setup(Random rng, NoiseAlgorithm noiseAlgorithm, SettingStore settings) {
		this.rng = rng;
		this.noiseAlgorithm = noiseAlgorithm;
		float rangeMin = settings.getRangeMin();
		float rangeMax = settings.getRangeMax();
		float rangeDelta = rangeMax - rangeMin;
		if (settings.isPrecisionAndRangeRelative()) {
			float mean = 25f;
			rangeMin = mean - (rangeDelta / 2);
		}
		this.rangeMin = rangeMin;
		this.rangeDelta = (int) rangeDelta;
		this.precisionSetting = settings.getPrecision();
	}

	/**
	 * This method returns a complete SimpleSensorData object.
	 * @return SimpleSensorData
	 */
	public SensorData getData() {
		String unit;
		float current = generateCurrent();
		if (this.rng.nextBoolean()) {
			unit = "°F";
			current = cToF(current);
		} else {
			unit = "°C";
		}
		float precision = this.precisionSetting;
		return new SimpleSensorData(current, precision, unit);
	}

	/**
	 * Generates the value to be used as "currentValue" in the SensorData object.
	 * @return float The final value.
	 */
	private float generateCurrent() {
		float current = this.rng.nextInt(this.rangeDelta) + this.rng.nextFloat();
		current = this.rangeMin + this.noiseAlgorithm.addNoise(current);
		return current;
	}

	/**
	 * Converts values from Celsius to Farenheit.
	 * @param celsiusVal The value in Celsius.
	 * @return float The value in Farenheit.
	 */
	private float cToF(float celsiusVal) {
		return (32f + (celsiusVal * 1.8f));
	}
}
