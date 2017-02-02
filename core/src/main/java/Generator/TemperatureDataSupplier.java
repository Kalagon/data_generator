package Generator;

import Main.SettingStore;

import java.util.Random;

/**
 * Generates SensorData objects filled with temperature data.
 */
public class TemperatureDataSupplier implements SensorDataSupplier {

	private float rangeMin;
	private int rangeDelta;
	private float precisionSetting;
	private Random rng;
	private NoiseAlgorithm noiseAlgorithm;

	public TemperatureDataSupplier(Random rng, NoiseAlgorithm noiseAlgorithm, SettingStore settings) {
		this.rng = rng;
		this.noiseAlgorithm = noiseAlgorithm;
		float rangeMin = settings.getRangeMin();
		float rangeMax = settings.getRangeMax();
		float rangeDelta = rangeMax - rangeMin;
		if (settings.isPrecisionAndRangeRelative()) {
			float mean = 25f;
			rangeMin = mean - ( rangeDelta / 2 );
		}
		this.rangeMin = rangeMin;
		this.rangeDelta = (int) rangeDelta;
		this.precisionSetting = settings.getPrecision();
	}


	/**
	 * Generates the SensorData object.
 	 * @return The finished data object.
	 */
	@Override
	public SensorData get() {
		float current = this.rng.nextInt(this.rangeDelta) + this.rng.nextFloat();
		current = this.rangeMin + this.noiseAlgorithm.addNoise(current);
		String unit = "°C";
		if (this.rng.nextBoolean()) {
			unit = "°F";
			current = ( 32f + ( current * 1.8f ) );
		}
		float precision = this.precisionSetting;
		return new SensorData(current, precision, unit);
	}
}
