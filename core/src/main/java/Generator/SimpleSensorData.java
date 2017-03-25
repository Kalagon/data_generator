package Generator;

/**
 * Template class for all kinds of SensorData objects.
 */
public class SimpleSensorData implements SensorData {
	/**
	 * The value of the last measurement.
	 */
	private float currentValue;

	/**
	 * The maximum deviation of the measurement under "normal" circumstances.
	 */
	private float precision;

	private String measurementUnit;

	public SimpleSensorData(float currentValue, float precision, String measurementUnit) {
		this.currentValue = currentValue;
		this.precision = precision;
		this.measurementUnit = measurementUnit;
	}

	public float getCurrentValue() {
		return currentValue;
	}

	public float getPrecision() {
		return precision;
	}

	public String getMeasurementUnit() {
		return measurementUnit;
	}

	@Override
	public String toString() {
		return this.toString(",");
	}

	public String toString(String separator) {
		return "currentValue:" + currentValue + separator +
			   "precision:" + precision + separator +
			   "measurementUnit:" + measurementUnit;
	}
}
