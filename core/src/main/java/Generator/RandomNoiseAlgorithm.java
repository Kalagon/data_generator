package Generator;

import Main.NoiseSettingStore;
import Main.RandomNoiseSettingStore;

import java.util.Random;

/**
 * Adds random noise based on a user-defined factor.
 */
public class RandomNoiseAlgorithm implements NoiseAlgorithm {
	private Random rng;
	private float noiseFactor;
	private int range;

	/**
	 * Fills the blank object with the correct values based on the given settings. The NoiseSettingStore is casted to a RandomNoiseSettingStore without checking. It must be ensured that settings is an instance of RandomNoiseSettingStore beforehand.
	 *
	 * @param settings The requested settings.
	 */
	@Override
	public void setUp(NoiseSettingStore settings) {
		assert(settings instanceof RandomNoiseSettingStore);
		RandomNoiseSettingStore tmpSettings = (RandomNoiseSettingStore) settings;
		this.rng = new Random(tmpSettings.getSeed());
		this.noiseFactor = tmpSettings.getNoiseFactor();
		this.range = tmpSettings.getRange();
	}

	/**
	 * Used to add noise to an integer value.
	 *
	 * @param inputValue The clean value.
	 * @return int
	 */
	@Override
	public int addNoise(int inputValue) {
		int result = inputValue;
		boolean applyNoise = (rng.nextFloat() <= noiseFactor);
		if (applyNoise) {
			int noiseValue = rng.nextInt(this.range * 2);
			result = ( inputValue + ( noiseValue - this.range ) );
		}
		return result;
	}

	/**
	 * Used to add noise to a float value.
	 *
	 * @param inputValue The clean float value.
	 * @return float
	 */
	@Override
	public float addNoise(float inputValue) {
		float result = inputValue;
		boolean applyNoise = (rng.nextFloat() <= noiseFactor);
		if (applyNoise) {
			float noiseValue = rng.nextInt(this.range * 2) + rng.nextFloat();
			result = ( inputValue + ( noiseValue - this.range ) );
		}
		return result;
	}
}
